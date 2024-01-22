package com.wellness.retreat.scheduler.controllers;

import com.wellness.retreat.scheduler.models.dtos.GuestDTO;
import com.wellness.retreat.scheduler.models.entities.Guest;
import com.wellness.retreat.scheduler.services.GuestService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public ResponseEntity<GuestDTO> createGuest(@Valid @RequestBody GuestDTO guestDTO) {
        GuestDTO savedGuest = guestService.saveGuest(guestDTO);
        return ResponseEntity.ok(savedGuest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestDTO> getGuestById(@PathVariable Long id) {
        GuestDTO guestDTO = guestService.getGuestById(id);
        return guestDTO != null ? ResponseEntity.ok(guestDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<GuestDTO>> getAllGuests() {
        return ResponseEntity.ok(guestService.getAllGuests());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestDTO> updateGuest(@Valid @PathVariable Long id, @RequestBody GuestDTO guestDTO) {
        GuestDTO updatedGuest = guestService.saveGuest(guestDTO);
        return ResponseEntity.ok(updatedGuest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.ok().build();
    }
}
