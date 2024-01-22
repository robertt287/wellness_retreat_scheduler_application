package com.wellness.retreat.scheduler.repositories;

import com.wellness.retreat.scheduler.models.entities.Retreat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RetreatRepository extends JpaRepository<Retreat, Long> {
    List<Retreat> findByTitleContaining(String title);

    @Query
    List<Retreat> findRetreatsBetweenDates(LocalDateTime start, LocalDateTime end);

    List<Retreat> findRetreatsByCriteria(@Param("title") String title,
                                         @Param("startDate") LocalDateTime startDate,
                                         @Param("endDate") LocalDateTime endDate);
}


