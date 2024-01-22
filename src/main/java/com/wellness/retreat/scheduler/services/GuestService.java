package com.wellness.retreat.scheduler.services;

import com.wellness.retreat.scheduler.models.dtos.GuestDTO;
import java.util.List;


public interface GuestService {
    GuestDTO saveGuest(GuestDTO guestDTO);
    GuestDTO getGuestById(Long id);
    List<GuestDTO> getAllGuests();
    void deleteGuest(Long id);}