package com.example.spring_new.controller;


import com.example.spring_new.dto.cityDto.CityRequest;
import com.example.spring_new.dto.cityDto.CityResponse;
import com.example.spring_new.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/compos")
public class CityController {


    @Autowired
    public  CityService cityService;


    @PostMapping
    public CityResponse create(@RequestBody CityRequest cityRequest){
        return cityService.create(cityRequest);
    }


}
