package com.wellness.retreat.scheduler.controllers;

import com.wellness.retreat.scheduler.models.dtos.RetreatDTO;
import com.wellness.retreat.scheduler.services.RetreatService;
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
    public ResponseEntity<RetreatDTO> createRetreat(@RequestBody RetreatDTO retreatDTO) {
        RetreatDTO savedRetreat = retreatService.saveRetreat(retreatDTO);
        return ResponseEntity.ok(savedRetreat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RetreatDTO> getRetreatById(@PathVariable Long id) {
        RetreatDTO retreatDTO = retreatService.getRetreatById(id);
        return retreatDTO != null ? ResponseEntity.ok(retreatDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<RetreatDTO>> getAllRetreats() {
        return ResponseEntity.ok(retreatService.getAllRetreats());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RetreatDTO> updateRetreat(@PathVariable Long id, @RequestBody RetreatDTO retreatDTO) {
        RetreatDTO updatedRetreat = retreatService.saveRetreat(retreatDTO);
        return ResponseEntity.ok(updatedRetreat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRetreat(@PathVariable Long id) {
        retreatService.deleteRetreat(id);
        return ResponseEntity.ok().build();
    }
}