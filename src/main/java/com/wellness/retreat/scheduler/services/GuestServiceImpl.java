package com.wellness.retreat.scheduler.services;

import com.wellness.retreat.scheduler.models.dtos.GuestDTO;
import com.wellness.retreat.scheduler.models.entities.Guest;
import com.wellness.retreat.scheduler.repositories.GuestRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
    public class GuestServiceImpl implements GuestService {

        private final GuestRepository guestRepository;

        public GuestServiceImpl(GuestRepository guestRepository) {
            this.guestRepository = guestRepository;
        }

        @Override
        public GuestDTO saveGuest(GuestDTO guestDTO) {
            Guest guest = convertToEntity(guestDTO);
            Guest savedGuest = guestRepository.save(guest);
            return convertToDTO(savedGuest);
        }


        @Override
        public GuestDTO getGuestById(Long id) {
            return guestRepository.findById(id)
                    .map(this::convertToDTO)
                    .orElse(null);
        }

        @Override
        public List<GuestDTO> getAllGuests() {
            return guestRepository.findAll().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public void deleteGuest(Long id) {
            guestRepository.deleteById(id);
        }

        private Guest convertToEntity(GuestDTO guestDTO) {
            Guest guest = new Guest();
            BeanUtils.copyProperties(guestDTO, guest);
            return guest;
        }

        private GuestDTO convertToDTO(Guest guest) {
            GuestDTO guestDTO = new GuestDTO();
            BeanUtils.copyProperties(guest, guestDTO);
            return guestDTO;
        }
    }

