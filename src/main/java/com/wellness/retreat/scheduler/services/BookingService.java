package com.wellness.retreat.scheduler.services;

import com.wellness.retreat.scheduler.models.dtos.BookingDTO;

import java.util.List;

public interface BookingService {
    BookingDTO saveBooking(BookingDTO bookingDTO);

    BookingDTO getBookingById(Long id);

    List<BookingDTO> getAllBookings();

    void deleteBooking(Long id);
}

