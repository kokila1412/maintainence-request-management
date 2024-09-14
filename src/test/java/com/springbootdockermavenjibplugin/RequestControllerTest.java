package com.springbootdockermavenjibplugin;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.springbootdockermavenjibplugin.controllers.RequestController;
import com.springbootdockermavenjibplugin.dto.RequestDto;
import com.springbootdockermavenjibplugin.models.Request;
import com.springbootdockermavenjibplugin.repositories.RequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
 @ExtendWith(MockitoExtension.class)
public class RequestControllerTest
{
    @InjectMocks
    RequestController requestController;

    @Mock
    RequestRepository requestRepository;

    @Test
    public void testAddRequest()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Request employee = new Request();
        employee.setId(1);
        when(requestRepository.save(any(Request.class))).thenReturn(employee);

        RequestDto requestToAdd = new RequestDto("Kokila", "High", "Testign Maitainence", "kokila", "jyoti");
        ResponseEntity responseEntity = requestController.create(requestToAdd);

        assertThat(responseEntity.getStatusCode().value()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }

    @Test
    public void testFindAll()
    {
        // given
        Request requestToAdd = new Request("Kokila", "High", "Testign Maitainence", "kokila", "jyoti");

        List<Request> list = new ArrayList<Request>();
        list.add(requestToAdd);

        when(requestRepository.findAll()).thenReturn(list);

        // when
        ResponseEntity<List<RequestDto>> result = requestController.getAll();

        // then
        assertThat(result.getBody().size()).isEqualTo(1);

        assertThat(result.getBody().get(0).getOwner())
                .isEqualTo(list.get(0).getOwner());


    }
}
