package com.wellness.retreat.scheduler.repositories;

import com.wellness.retreat.scheduler.models.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByName(String name);
    Guest findByEmail(String email);
}

