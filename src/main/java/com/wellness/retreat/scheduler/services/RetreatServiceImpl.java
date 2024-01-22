package com.wellness.retreat.scheduler.services;

import com.wellness.retreat.scheduler.models.dtos.RetreatDTO;
import com.wellness.retreat.scheduler.models.entities.Retreat;
import com.wellness.retreat.scheduler.repositories.RetreatRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetreatServiceImpl implements RetreatService {

    private final RetreatRepository retreatRepository;

    public RetreatServiceImpl(RetreatRepository retreatRepository) {
        this.retreatRepository = retreatRepository;
    }

    @Override
    public RetreatDTO saveRetreat(RetreatDTO retreatDTO) {
        Retreat retreat = convertToEntity(retreatDTO);
        Retreat savedRetreat = retreatRepository.save(retreat);
        return convertToDTO(savedRetreat);
    }

    @Override
    public RetreatDTO getRetreatById(Long id) {
        return retreatRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public List<RetreatDTO> getAllRetreats() {
        return retreatRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRetreat(Long id) {
        retreatRepository.deleteById(id);
    }

    @Override
    public List<RetreatDTO> findRetreatsByCriteria(String title, LocalDateTime startDate, LocalDateTime endDate) {
        return retreatRepository.findRetreatsByCriteria(title, startDate, endDate).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
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