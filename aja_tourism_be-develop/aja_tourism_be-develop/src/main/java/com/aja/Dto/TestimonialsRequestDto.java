package com.aja.Dto;

import com.aja.entity.Packages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestimonialsRequestDto {
    private String name;
    private Integer rating;
    private String review;
    //private Packages packages;
    private String packageName; 
    private String image;
}
