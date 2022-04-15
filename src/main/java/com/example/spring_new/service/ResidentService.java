package com.example.spring_new.service;


import com.example.spring_new.dto.residentDto.ResidentRequest;
import com.example.spring_new.dto.residentDto.ResidentResponse;
import com.example.spring_new.entity.City;
import com.example.spring_new.entity.Resident;
import com.example.spring_new.repository.CityRepository;
import com.example.spring_new.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public ResidentResponse update(long id,ResidentRequest residentRequest){
        Optional<Resident> resident = residentRepository.findById(id);
        mapToUpdate(resident.get(),residentRequest);

        return mapToResponse(residentRepository.save(resident.get()));

    }

    public ResidentResponse getById(long id){
        Optional<Resident> resident  = residentRepository.findById(id);
        return mapToResponse(resident.get());
    }

 public ResidentResponse deleteById(long id){
        Resident resident = residentRepository.findById(id).get();
        residentRepository.deleteById(id);

        return mapToResponse(resident);
 }

    public Resident mapToResident(ResidentRequest residentRequest){

        Resident resident = new Resident();
        resident.setName(residentRequest.getResident_name());
        resident.setLastname(residentRequest.getResident_lastname());

        City city = cityRepository.findById(residentRequest.getCityId()).get();
        resident.setCity(city);
        return resident;
    }
    public Resident mapToUpdate(Resident resident, ResidentRequest residentRequest){
        resident.setName(residentRequest.getResident_name());
        resident.setLastname(resident.getLastname());
        City city = cityRepository.findById(residentRequest.getCityId()).get();
        resident.setCity(city);
        return resident;
    }

    public ResidentResponse mapToResponse(Resident resident){

        ResidentResponse response  = new ResidentResponse();
        response.setId(String.valueOf(resident.getResidentId()));
        response.setResident_name(resident.getName());
        response.setResident_lastname(resident.getLastname());
        response.setCity(resident.getCity());
        return response;
    }
}
