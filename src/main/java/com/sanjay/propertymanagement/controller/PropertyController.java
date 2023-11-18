package com.sanjay.propertymanagement.controller;

import com.sanjay.propertymanagement.dto.PropertyDto;
import com.sanjay.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity<PropertyDto> saveProperty (@RequestBody PropertyDto propertyDto) {
        propertyDto = propertyService.saveProperty(propertyDto);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>> getAllProperties () {
        List<PropertyDto> propertyList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDto>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDto> updateProperty (@RequestBody PropertyDto propertyDto, @PathVariable Long id) {
        propertyDto = propertyService.updateProperty(propertyDto,id);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-description/{id}")
    public ResponseEntity<PropertyDto> updatePropertyDescription (@RequestBody PropertyDto propertyDto, @PathVariable Long id) {
        propertyDto = propertyService.updatePropertyDescription(propertyDto,id);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/properties/delete/{id}")
    public  ResponseEntity<Void> deleteProperty (@PathVariable Long id) throws Exception{
        propertyService.deleteProperty(id);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }

    @GetMapping("/properties/{id}")
    public ResponseEntity<PropertyDto> getPropertyById (@PathVariable Long id) throws Exception{
        PropertyDto propertyDto = propertyService.getPropertyById(id);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return responseEntity;
    }

}
