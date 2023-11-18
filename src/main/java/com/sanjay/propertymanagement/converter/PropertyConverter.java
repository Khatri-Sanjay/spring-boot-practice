package com.sanjay.propertymanagement.converter;

import com.sanjay.propertymanagement.dto.PropertyDto;
import com.sanjay.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDtoToEntity (PropertyDto propertyDto) {

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDto.getTitle());
        propertyEntity.setDescription(propertyDto.getDescription());
        propertyEntity.setOwnerName(propertyDto.getOwnerName());
        propertyEntity.setOwnerEmail(propertyDto.getOwnerEmail());
        propertyEntity.setPrice(propertyDto.getPrice());
        propertyEntity.setAddress(propertyDto.getAddress());

        return propertyEntity;
    }

    public PropertyDto convertEntityToDto (PropertyEntity propertyEntity) {

        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setId(propertyEntity.getId());
        propertyDto.setTitle(propertyEntity.getTitle());
        propertyDto.setDescription(propertyEntity.getDescription());
        propertyDto.setOwnerName(propertyEntity.getOwnerName());
        propertyDto.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDto.setPrice(propertyEntity.getPrice());
        propertyDto.setAddress(propertyEntity.getAddress());

        return propertyDto;
    }
}
