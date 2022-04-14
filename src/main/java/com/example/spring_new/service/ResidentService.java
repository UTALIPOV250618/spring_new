package com.example.spring_new.service;


import com.example.spring_new.dto.residentDto.ResidentRequest;
import com.example.spring_new.dto.residentDto.ResidentResponse;
import com.example.spring_new.entity.City;
import com.example.spring_new.entity.Resident;
import com.example.spring_new.repository.CityRepository;
import com.example.spring_new.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResidentService {

    public final ResidentRepository residentRepository;
    public final CityRepository cityRepository;


    public ResidentResponse create(ResidentRequest residentRequest){
        Resident resident = mapToResident(residentRequest);
        residentRepository.save(resident);
        return mapToResponse(resident);
    }

    public Resident mapToResident(ResidentRequest residentRequest){

        Resident resident = new Resident();
        resident.setName(residentRequest.getResident_name());
        resident.setLastname(residentRequest.getResident_lastname());

        City city = cityRepository.findById(resident.getResidentId()).get();
        resident.setCity(city);
        return resident;
    }

    public ResidentResponse mapToResponse(Resident resident){
        ResidentResponse response  = new ResidentResponse();
        response.setId(String.valueOf(resident.getResidentId()));
        response.setResident_name(resident.getName());
        response.setResident_lastname(resident.getLastname());
        response.setCityId(resident.getCity().getId());
        return response;
    }
}
