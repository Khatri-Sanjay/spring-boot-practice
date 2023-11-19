package com.sanjay.propertymanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

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
    @Pattern(regexp = "^[^\\\\/:*?\"<>|]+$", message = "Not valid")
    private String title;

    private String description;

    @NotBlank
    private String ownerName;

    @Column(name = "owner_email")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty
    private String ownerEmail;

    @Pattern(regexp = "(\\+977)?[9][6-9]\\d{8}", message = "Invalid Owner Phone Number")
    private String ownerPhoneNumber;

    @NonNull
    private Double price;

    @NotBlank
    private String address;

}
