package com.telandash.intranet.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Represents a user within the intranet system.
 * This class includes details such as user identification, status, email, and personal identification number (DNI),
 * along with timestamps for creation and last update to support auditing.
 * Utilizes JPA for ORM and Lombok for reducing boilerplate code.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class UsersModel {
    /**
     * Unique identifier for the user, serving as the primary key within the database.
     * This ID is automatically generated upon creation to ensure each user has a distinct identifier.
     */
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User's first name, used for personalization and display purposes across the application.
     */
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name cannot exceed 50 characters or less")
    private String name;

    /**
     * User's last name, complementing the first name for full identification and personalization.
     */
    @NotBlank(message = "Lastname cannot be blank")
    @Size(max = 50, message = "Lastname cannot exceed 50 characters or less")
    private String lastname;

    /**
     * Status indicating whether the user is active or inactive.
     */
    @NonNull
    private Boolean status;

    /**
     * The user's email address, which must be unique and not blank.
     */
    @NotBlank(message = "Email cannot be blank")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    /**
     * The user's personal identification number (DNI), which must be unique and not blank.
     */
    @NotBlank(message = "DNI cannot be blank")
    @Size(max = 255, message = "DNI cannot exceed 255 characters")
    private String dni;

    /**
     * The role assigned to this entity, defining the access permissions and capabilities within the system.
     * This field establishes a many-to-one relationship with the RoleModel, indicating that multiple entities of this type
     * can be associated with a single role, but each entity can only have one role at a time.
     * The relationship is critical for enforcing access controls and permissions, ensuring each entity operates within its designated capacities.
     */
    @ManyToOne
    @JoinColumn(name = "rol", nullable = false)
    private RoleModel role;

    /**
     * Username used to log in and must be unique within the system.
     */
    @NotBlank(message = "Username cannot be blank")
    @Size(max = 20, message = "Username length must be 20 characters or less")
    private String username;

    /**
     * User's password for system access. Stored securely and used for authentication purposes.
     */
    @NotBlank(message = "Password cannot be blank")
    @Size(max = 20, message = "Password cannot exceed 20 characters or less")
    private String password;

    /**
     * The date and time when the user record was created.
     * This attribute is used for auditing, tracking the initial creation of the user record.
     */
    @Column(name = "createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.of("America/Lima"));

    /**
     * The date and time when the user record was created.
     * This attribute is used for auditing, tracking the initial creation of the user record.
     */
    @Column(name = "updatedAt")
    @UpdateTimestamp
    private ZonedDateTime updatedAt = ZonedDateTime.now(ZoneId.of("America/Lima"));
}
