package com.example.spring_new.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ResidentId;
    private String name;
    private String lastname;
    @ManyToOne()
    @JoinColumn(name = "city_id")
    @JsonIgnore
    private City city;



}