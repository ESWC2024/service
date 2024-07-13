package com.example.eswc.service;

import com.example.eswc.model.LostPlace;
import com.example.eswc.repository.LostPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LostPlaceService {

    @Autowired
    private LostPlaceRepository lostPlaceRepository;

    public void registerLostPlace(LostPlace lostPlace) {
    lostPlaceRepository.save(lostPlace);
}

public LostPlace getLostPlaceById(Long id) {
    Optional<LostPlace> lostPlaceOptional = lostPlaceRepository.findById(id);
    return lostPlaceOptional.orElse(null);
}

public List<LostPlace> getAllLostPlaces() {
    return lostPlaceRepository.findAll();
}

public boolean updateLostPlace(Long id, LostPlace updatedLostPlace) {
    Optional<LostPlace> existingPlaceOptional = lostPlaceRepository.findById(id);
    if (existingPlaceOptional.isPresent()) {
        updatedLostPlace.setId(id);
        lostPlaceRepository.save(updatedLostPlace);
        return true;
    }
    return false;
}

public boolean deleteLostPlace(Long id) {
    Optional<LostPlace> lostPlaceOptional = lostPlaceRepository.findById(id);
    if (lostPlaceOptional.isPresent()) {
        lostPlaceRepository.deleteById(id);
        return true;
    }
    return false;
}
}
