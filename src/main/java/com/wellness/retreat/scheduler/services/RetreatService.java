package com.wellness.retreat.scheduler.services;

import com.wellness.retreat.scheduler.models.dtos.RetreatDTO;
import com.wellness.retreat.scheduler.models.entities.Retreat;
import com.wellness.retreat.scheduler.repositories.RetreatRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetreatService {

    private final RetreatRepository retreatRepository;

    public RetreatService(RetreatRepository retreatRepository) {
        this.retreatRepository = retreatRepository;
    }

    public RetreatDTO saveRetreat(RetreatDTO retreatDTO) {
        Retreat retreat = convertToEntity(retreatDTO);
        Retreat savedRetreat = retreatRepository.save(retreat);
        return convertToDTO(savedRetreat);
    }

    public RetreatDTO getRetreatById(Long id) {
        return retreatRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null); // or handle as needed
    }

    public List<RetreatDTO> getAllRetreats() {
        return retreatRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteRetreat(Long id) {
        retreatRepository.deleteById(id);
    }

    private Retreat convertToEntity(RetreatDTO retreatDTO) {
        Retreat retreat = new Retreat();
        BeanUtils.copyProperties(retreatDTO, retreat);

        return retreat;
    }

    private RetreatDTO convertToDTO(Retreat retreat) {
        RetreatDTO retreatDTO = new RetreatDTO();
        BeanUtils.copyProperties(retreat, retreatDTO);

        return retreatDTO;
    }
}