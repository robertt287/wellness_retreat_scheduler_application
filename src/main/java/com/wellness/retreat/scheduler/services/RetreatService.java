package com.wellness.retreat.scheduler.services;

import com.wellness.retreat.scheduler.models.dtos.RetreatDTO;
import com.wellness.retreat.scheduler.models.entities.Retreat;
import com.wellness.retreat.scheduler.repositories.RetreatRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public interface RetreatService {
    RetreatDTO saveRetreat(RetreatDTO retreatDTO);
    RetreatDTO getRetreatById(Long id);
    List<RetreatDTO> getAllRetreats();
    void deleteRetreat(Long id);

    List<RetreatDTO> findRetreatsByCriteria(String title, LocalDateTime startDate, LocalDateTime endDate);
}

