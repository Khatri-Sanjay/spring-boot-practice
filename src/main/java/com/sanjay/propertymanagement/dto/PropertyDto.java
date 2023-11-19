package com.sanjay.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDto {

    private Long Id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private String ownerPhoneNumber;
    private Double price;
    private String address;

}
