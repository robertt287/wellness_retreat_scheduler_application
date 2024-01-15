package com.wellness.retreat.scheduler.services;

import com.wellness.retreat.scheduler.models.entities.Retreat;
import com.wellness.retreat.scheduler.repositories.RetreatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetreatService {

    private final RetreatRepository retreatRepository;

    public RetreatService(RetreatRepository retreatRepository) {
        this.retreatRepository = retreatRepository;
    }

    public Retreat saveRetreat(Retreat retreat) {
        // You can add validation logic here
        return retreatRepository.save(retreat);
    }

    public Optional<Retreat> getRetreatById(Long id) {
        return retreatRepository.findById(id);
    }

    public List<Retreat> getAllRetreats() {
        return retreatRepository.findAll();
    }

    public void deleteRetreat(Long id) {
        retreatRepository.deleteById(id);
    }
}