package com.telandash.intranet.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {

    @NonNull
    private Boolean status;

    @NotBlank(message = "Email cannot be blank")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String email;

    @NotBlank(message = "DNI cannot be blank")
    @Size(max = 255, message = "DNI cannot exceed 255 characters")
    private String dni;

    private Long role;
}
