package com.wellness.retreat.scheduler.models.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class BookingDTO {
    @NotNull(message = "Guest ID is required")
    private Long id;
    @NotNull(message = "Retreat ID is required")
    private Long guestId;
    @NotNull(message = "Booking date is required")
    @FutureOrPresent(message = "Booking date must be in the present or future")
    private Long retreatId;
    private LocalDateTime bookingDate;
    @NotNull(message = "Check-in date is required")
    @FutureOrPresent(message = "Check-in date must be in the present or future")
    private LocalDateTime checkInDate;
    @NotNull(message = "Check-out date is required")
    @FutureOrPresent(message = "Check-out date must be in the present or future")
    private LocalDateTime checkOutDate;
    private String status;
}