package com.wellness.retreat.scheduler.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetreatDTO {
    private Long id;
    private String title;
    private String description;
    private Set<GuestDTO> guests;
}