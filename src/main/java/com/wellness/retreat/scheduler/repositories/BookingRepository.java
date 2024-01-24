package com.wellness.retreat.scheduler.repositories;


import com.wellness.retreat.scheduler.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByGuestId(Long guestId);

    List<Booking> findByRetreatId(Long retreatId);

    @Query("SELECT b FROM Booking b WHERE b.checkInDate >= :startDate AND b.checkOutDate <= :endDate")
    List<Booking> findBookingsWithinDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
