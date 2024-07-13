package com.example.eswc.service;

import com.example.eswc.model.GovernmentOffice;
import com.example.eswc.repository.GovernmentOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GovernmentOfficeService {

    @Autowired
    private GovernmentOfficeRepository governmentOfficeRepository;

    public void registerGovernmentOffice(GovernmentOffice governmentOffice) {
    governmentOfficeRepository.save(governmentOffice);
}

public GovernmentOffice getGovernmentOfficeById(Long id) {
    Optional<GovernmentOffice> governmentOfficeOptional = governmentOfficeRepository.findById(id);
    return governmentOfficeOptional.orElse(null);
}

public List<GovernmentOffice> getAllGovernmentOffices() {
    return governmentOfficeRepository.findAll();
}

public boolean updateGovernmentOffice(Long id, GovernmentOffice updatedGovernmentOffice) {
    Optional<GovernmentOffice> existingOfficeOptional = governmentOfficeRepository.findById(id);
    if (existingOfficeOptional.isPresent()) {
        updatedGovernmentOffice.setId(id);
        governmentOfficeRepository.save(updatedGovernmentOffice);
        return true;
    }
    return false;
}

public boolean deleteGovernmentOffice(Long id) {
    Optional<GovernmentOffice> governmentOfficeOptional = governmentOfficeRepository.findById(id);
    if (governmentOfficeOptional.isPresent()) {
        governmentOfficeRepository.deleteById(id);
        return true;
    }
    return false;
}
}
