package com.example.spring_new.controller;


import com.example.spring_new.dto.residentDto.ResidentRequest;
import com.example.spring_new.dto.residentDto.ResidentResponse;
import com.example.spring_new.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/resident")
public class ResidentController {

    public final ResidentService service;

    @PostMapping
    public ResidentResponse create(@RequestBody ResidentRequest residentRequest){
        return service.create(residentRequest);
    }
    @PutMapping("/{id}")
    public ResidentResponse update(@PathVariable long id,@RequestBody ResidentRequest residentRequest){
        return service.update(id,residentRequest);
    }
    @GetMapping("/{id}")
    public ResidentResponse getById(@PathVariable long id){
        return  service.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResidentResponse deleteById(@PathVariable long id){
        return  service.deleteById(id);
    }

}
