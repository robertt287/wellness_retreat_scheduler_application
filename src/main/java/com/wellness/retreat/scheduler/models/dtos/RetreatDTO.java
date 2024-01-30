package com.wellness.retreat.scheduler.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
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
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}