package com.wellness.retreat.scheduler.controllers;

import com.wellness.retreat.scheduler.models.entities.Retreat;
import com.wellness.retreat.scheduler.services.RetreatService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retreats")
@Validated
public class RetreatController {

    private final RetreatService retreatService;

    public RetreatController(RetreatService retreatService) {
        this.retreatService = retreatService;
    }

    @PostMapping
    public ResponseEntity<Retreat> createRetreat(@Valid @RequestBody Retreat retreat) {
        Retreat savedRetreat = retreatService.saveRetreat(retreat);
        return ResponseEntity.ok(savedRetreat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Retreat> getRetreatById(@PathVariable Long id) {
        return retreatService.getRetreatById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Retreat>> getAllRetreats() {
        return ResponseEntity.ok(retreatService.getAllRetreats());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Retreat> updateRetreat(@PathVariable Long id, @Valid @RequestBody Retreat retreatDetails) {
        return retreatService.getRetreatById(id)
                .map(retreat -> {
                    // Update retreat details
                    return ResponseEntity.ok(retreatService.saveRetreat(retreat));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRetreat(@PathVariable Long id) {
        retreatService.deleteRetreat(id);
        return ResponseEntity.ok().build();
    }
}