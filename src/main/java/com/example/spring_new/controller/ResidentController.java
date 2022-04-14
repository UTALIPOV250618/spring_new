package com.example.spring_new.controller;


import com.example.spring_new.dto.residentDto.ResidentRequest;
import com.example.spring_new.dto.residentDto.ResidentResponse;
import com.example.spring_new.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/resident")
public class ResidentController {

    public final ResidentService service;

    @PostMapping
    public ResidentResponse create(@RequestBody ResidentRequest residentRequest){
        return service.create(residentRequest);
    }

}
