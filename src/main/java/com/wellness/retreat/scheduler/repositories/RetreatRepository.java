package com.wellness.retreat.scheduler.repositories;

import com.wellness.retreat.scheduler.models.entities.Retreat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RetreatRepository extends JpaRepository<Retreat, Long> {

    List<Retreat> findByTitleContaining(String title);

    List<Retreat> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDateTime start, LocalDateTime end);

    @Query("SELECT r FROM Retreat r WHERE " +
            "(:title IS NULL OR r.title LIKE CONCAT('%', :title, '%')) AND " +
            "(:startDate IS NULL OR r.startDate >= :startDate) AND " +
            "(:endDate IS NULL OR r.endDate <= :endDate)")
    List<Retreat> findRetreatsByCriteria(@Param("title") String title, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}

