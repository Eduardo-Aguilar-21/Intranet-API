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
 * Represents an institution within the intranet system.
 * This class defines the details of institutions that can be registered in the system, including their name and associated type.
 * It includes details such as the institution's unique identifier, descriptive name, and a reference to its type.
 * Utilizes JPA for ORM and Lombok for reducing boilerplate code.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "institutions")
public class InstitutionsModel {
    /**
     * Unique identifier for the institution, serving as the primary key within the database.
     * This ID is automatically generated upon creation to ensure each institution has a distinct identifier.
     * It facilitates efficient indexing and retrieval of institution records.
     */
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Descriptive name of the institution, providing a clear identifier for the institution within the system.
     * The name field is crucial for administrators and users to identify and differentiate between institutions.
     */
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String name;

    /**
     * The type of the institution, categorizing it within the system.
     * This field links to the InstitutionsTypeModel, indicating the classification of the institution based on predefined types.
     * It is a critical aspect of managing institutions, allowing for organized categorization and retrieval.
     */
    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private InstitutionsTypeModel institutionsTypeModel;

    /**
     * The date and time when the institutions record was created.
     * This attribute is used for auditing, tracking the initial creation of the institutions record.
     */
    @Column(name = "createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.of("America/Lima"));

    /**
     * The date and time when the institutions record was created.
     * This attribute is used for auditing, tracking the initial creation of the institutions record.
     */
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private ZonedDateTime updatedAt = ZonedDateTime.now(ZoneId.of("America/Lima"));
}
