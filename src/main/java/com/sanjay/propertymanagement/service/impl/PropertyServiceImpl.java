package com.sanjay.propertymanagement.service.impl;

import com.sanjay.propertymanagement.converter.PropertyConverter;
import com.sanjay.propertymanagement.dto.PropertyDto;
import com.sanjay.propertymanagement.entity.PropertyEntity;
import com.sanjay.propertymanagement.reprository.PropertyRepository;
import com.sanjay.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDto saveProperty(PropertyDto propertyDto) {

        PropertyEntity propertyEntity = propertyConverter.convertDtoToEntity(propertyDto);
        propertyEntity = propertyRepository.save(propertyEntity);
        propertyDto = propertyConverter.convertEntityToDto(propertyEntity);
        return propertyDto;
    }

    @Override
    public List<PropertyDto> getAllProperties() {

        List<PropertyEntity> propertyEntityList =  (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDto> propertyDtoList = new ArrayList<>();

        for(PropertyEntity pe : propertyEntityList) {
            PropertyDto propertyDto = propertyConverter.convertEntityToDto(pe);
            propertyDtoList.add(propertyDto);
        }

        return propertyDtoList;
    }

    @Override
    public PropertyDto getPropertyById(Long propertyId) throws Exception {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);

        PropertyDto dto = null;

        if(optionalPropertyEntity.isPresent()) {
            PropertyEntity propertyEntity = optionalPropertyEntity.get();
            dto = propertyConverter.convertEntityToDto(propertyEntity);
        } else {
            throw new Exception("Property Id : " + propertyId + " not found");
        }

        return dto;
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId) {

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);

        PropertyDto dto = null;

        if(optionalPropertyEntity.isPresent()) {
            PropertyEntity propertyEntity = optionalPropertyEntity.get();
            propertyEntity.setTitle(propertyDto.getTitle());
            propertyEntity.setDescription(propertyDto.getDescription());
            propertyEntity.setOwnerName(propertyDto.getOwnerName());
            propertyEntity.setOwnerEmail(propertyDto.getOwnerEmail());
            propertyEntity.setPrice(propertyDto.getPrice());
            propertyEntity.setAddress(propertyDto.getAddress());
            dto = propertyConverter.convertEntityToDto(propertyEntity);
            propertyRepository.save(propertyEntity);
        }

        return dto;
    }

    @Override
    public PropertyDto updatePropertyDescription(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);

        PropertyDto dto = null;

        if(optionalPropertyEntity.isPresent()) {
            PropertyEntity propertyEntity = optionalPropertyEntity.get();
            propertyEntity.setDescription(propertyDto.getDescription());
            dto = propertyConverter.convertEntityToDto(propertyEntity);
            propertyRepository.save(propertyEntity);
        }

        return dto;
    }

    @Override
    public void deleteProperty(Long id) throws Exception {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(id);

        if (optionalPropertyEntity.isPresent()) {
            propertyRepository.deleteById(id);
        } else {
            throw new Exception("User having id" + " " + id + " " + "is not available");
        }
    }
}
