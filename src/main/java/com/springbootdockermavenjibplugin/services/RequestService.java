package com.springbootdockermavenjibplugin.services;

import com.springbootdockermavenjibplugin.dto.RequestDto;
import com.springbootdockermavenjibplugin.models.Request;
import com.springbootdockermavenjibplugin.repositories.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;

    @Transactional
    public Optional<Request> create(RequestDto maintainenceRequest) {

        Request incomingRequest = Request.builder()
                .priority(maintainenceRequest.getPriority())
                .type(maintainenceRequest.getType())
                .description(maintainenceRequest.getDescription())
                .approver(maintainenceRequest.getApprover())
                .owner(maintainenceRequest.getOwner())
                .build();

        Request savedRequest = requestRepository.save(incomingRequest);

        return Optional.of(savedRequest);
    }

    @Transactional(readOnly = true)
    public List<RequestDto> getAll() {

        List<Request> requests = requestRepository.findAll();
        List<RequestDto> requestDtoList = new ArrayList<>();

        for (Request request : requests) {
            RequestDto requestDto = RequestDto.builder()
                    .priority(request.getPriority())
                    .type(request.getType())
                    .description(request.getDescription())
                    .approver(request.getApprover())
                    .owner(request.getOwner())
                    .build();

            requestDtoList.add(requestDto);
        }

        return requestDtoList;
    }
}
