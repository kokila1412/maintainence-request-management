package com.springbootdockermavenjibplugin.controllers;

import com.springbootdockermavenjibplugin.dto.RequestDto;
import com.springbootdockermavenjibplugin.models.Request;
import com.springbootdockermavenjibplugin.services.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/requests")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class RequestController {

    Logger logger = LoggerFactory.getLogger(RequestController.class);
    private final RequestService productService;

    @PostMapping
    public ResponseEntity<Request> create(@Valid @RequestBody RequestDto request){

        Optional<Request> productOptional = productService.create(request);
        if(!productOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productOptional.get(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RequestDto>> getAll(){
        logger.info("*****Setting Response Headers");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Access-Control-Allow-Origin", "true");
        headers.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, ORIGIN");

        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

}
