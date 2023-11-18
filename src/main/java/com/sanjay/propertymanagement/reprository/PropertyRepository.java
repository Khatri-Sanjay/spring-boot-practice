package com.sanjay.propertymanagement.reprository;

import com.sanjay.propertymanagement.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
}
