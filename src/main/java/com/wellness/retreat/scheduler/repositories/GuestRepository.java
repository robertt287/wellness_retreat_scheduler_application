package com.wellness.retreat.scheduler.repositories;

import com.wellness.retreat.scheduler.models.entities.Guest;
import com.wellness.retreat.scheduler.models.entities.Retreat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByName(String name);
    Guest findByEmail(String email);

    Set<Guest> findByRetreatsContaining(Retreat retreat);
}

