package com.wellness.retreat.scheduler.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class GuestDTO {
    private Long id;
    @NotBlank(message = "Invalid first name")
    private String firstName;
    @NotBlank(message = "Invalid last name")
    private String lastName;
    @NotBlank(message = "Invalid email")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message="Invalid phone number")
    private String phoneNumber;
}