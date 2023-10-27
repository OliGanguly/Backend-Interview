package com.example.CRUDOperations.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
//Vallidation


    @NotNull(message = "Name can not be null")
    private String name;
    @NotNull(message = "Email can not be null")
    @Email
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "Invalid Mobile Number")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
