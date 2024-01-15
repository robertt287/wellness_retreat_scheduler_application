package com.wellness.retreat.scheduler.services;

import com.wellness.retreat.scheduler.models.entities.Guest;
import com.wellness.retreat.scheduler.repositories.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Guest saveGuest(Guest guest) {
        // You can add validation logic here
        return guestRepository.save(guest);
    }

    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

}