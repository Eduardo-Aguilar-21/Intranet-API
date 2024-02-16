package com.telandash.intranet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Represents an institution type within the intranet system.
 * This class defines the various types of institutions that can be registered in the system, specifying the category or nature of each.
 * It includes details such as the institution type's unique identifier and descriptive name.
 * Utilizes JPA for ORM and Lombok for reducing boilerplate code.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "institutions_type")
public class InstitutionsTypeModel {
    /**
     * Unique identifier for the institution type, serving as the primary key within the database.
     * This ID is automatically generated upon creation to ensure each institution type has a distinct identifier.
     * It facilitates efficient indexing and retrieval of institution type records.
     */
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Descriptive name of the institution type, reflecting the nature or category of the institution it represents.
     * The name field is crucial for administrators and users to understand the classification of institutions within the system.
     */
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String name;

    /**
     * The date and time when the institutions type record was created.
     * This attribute is used for auditing, tracking the initial creation of the institutions type record.
     */
    @Column(name = "createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.of("America/Lima"));

    /**
     * The date and time when the institutions type record was created.
     * This attribute is used for auditing, tracking the initial creation of the institutions type record.
     */
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private ZonedDateTime updatedAt = ZonedDateTime.now(ZoneId.of("America/Lima"));
}
