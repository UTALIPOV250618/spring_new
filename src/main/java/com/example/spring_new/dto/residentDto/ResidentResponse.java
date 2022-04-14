package com.example.spring_new.dto.residentDto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResidentResponse {
    private String id;
    private String resident_name;
    private String resident_lastname;
    private Long cityId;
}
