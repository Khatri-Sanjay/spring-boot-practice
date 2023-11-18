package com.sanjay.propertymanagement.service;

import com.sanjay.propertymanagement.dto.PropertyDto;

import java.util.List;

public interface PropertyService {

    PropertyDto saveProperty(PropertyDto propertyDto);

    List <PropertyDto> getAllProperties();

    PropertyDto getPropertyById (Long propertyId) throws Exception;

    PropertyDto updateProperty (PropertyDto propertyDto, Long propertyId);

    PropertyDto updatePropertyDescription (PropertyDto propertyDto, Long propertyId);

    void deleteProperty (Long id) throws Exception;


}
