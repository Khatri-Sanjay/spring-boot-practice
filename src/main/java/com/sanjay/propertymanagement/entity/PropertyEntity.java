package com.sanjay.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Property")
@Getter
@Setter

//Lombok generates a default constructor without any parameters. This can be particularly useful,
// for example, when working with frameworks that require a default constructor or when you want to simplify object creation.
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Property_title", nullable = false)
    private String title;
    private String description;
    private String ownerName;

    @Column(name = "owner_email")
    private String ownerEmail;
    private Double price;
    private String address;

}
