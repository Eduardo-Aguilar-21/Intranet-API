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
 * Represents a role within the intranet system.
 * This class defines the various roles that can be assigned to users, specifying the access permissions and capabilities associated with each.
 * It includes details such as the role's unique identifier and descriptive name.
 * Utilizes JPA for ORM and Lombok for reducing boilerplate code.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class RoleModel {
    /**
     * Unique identifier for the role, serving as the primary key within the database.
     * This ID facilitates efficient indexing and retrieval of role records.
     */
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Descriptive name of the role, reflecting the nature of the access permissions it grants.
     * The name field is crucial for administrators to appropriately assign roles to users, facilitating the management of access controls within the system.
     */
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String name;

    /**
     * The date and time when the role record was created.
     * This attribute is used for auditing, tracking the initial creation of the role record.
     */
    @Column(name = "createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.of("America/Lima"));

    /**
     * The date and time when the role record was created.
     * This attribute is used for auditing, tracking the initial creation of the role record.
     */
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private ZonedDateTime updatedAt = ZonedDateTime.now(ZoneId.of("America/Lima"));
}
