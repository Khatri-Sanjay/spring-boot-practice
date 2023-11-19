package com.sanjay.propertymanagement.service;

import com.sanjay.propertymanagement.dto.PropertyDto;
import com.sanjay.propertymanagement.exception.PropertiesNotFoundException;

import java.util.List;

public interface PropertyService {

    PropertyDto saveProperty(PropertyDto propertyDto);

    List <PropertyDto> getAllProperties();

    PropertyDto getPropertyById (Long propertyId) throws PropertiesNotFoundException;

    PropertyDto updateProperty (PropertyDto propertyDto, Long propertyId);

    PropertyDto updatePropertyDescription (PropertyDto propertyDto, Long propertyId);

    void deleteProperty (Long id) throws PropertiesNotFoundException;


}
