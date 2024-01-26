package com.wellness.retreat.scheduler.services;

import com.wellness.retreat.scheduler.models.dtos.BookingDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookingService {
    BookingDTO saveBooking(BookingDTO bookingDTO);

    Optional<BookingDTO> getBookingById(Long id);

    List<BookingDTO> getAllBookings();

    void deleteBooking(Long id);

}

