package com.wellness.retreat.scheduler.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class RetreatDTO {
    private Long id;
    @NotBlank(message = "Title is required")
    private String title;
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;
    private Set<GuestDTO> guests;
}