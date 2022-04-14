package com.example.spring_new.service;


import com.example.spring_new.dto.cityDto.CityRequest;
import com.example.spring_new.dto.cityDto.CityResponse;
import com.example.spring_new.entity.City;
import com.example.spring_new.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class CityService {

    @Autowired
    public  CityRepository repository;

    public CityResponse create(CityRequest cityRequest){
        City city = mapToEntity(cityRequest);
        repository.save(city);
        return mapToResponse(city);
    }

    public City mapToEntity(CityRequest request){
        City city = new City();
        city.setName(request.getName());
        return city;
    }

    public CityResponse mapToResponse(City city){
        CityResponse cityResponse  = new CityResponse();
        cityResponse.setId(String.valueOf(city.getId()));
        cityResponse.setName(city.getName());
        return cityResponse;
    }
}
