package com.example.eswc.service;

import com.example.eswc.model.MissingPerson;
import com.example.eswc.repository.MissingPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissingPersonService {

    @Autowired
    private MissingPersonRepository missingPersonRepository;

    public void registerMissingPerson(MissingPerson missingPerson) {
    missingPersonRepository.save(missingPerson);
}

public MissingPerson getMissingPersonById(Long id) {
    Optional<MissingPerson> missingPersonOptional = missingPersonRepository.findById(id);
    return missingPersonOptional.orElse(null);
}

public List<MissingPerson> getAllMissingPersons() {
    return missingPersonRepository.findAll();
}

public boolean updateMissingPerson(Long id, MissingPerson updatedMissingPerson) {
    Optional<MissingPerson> existingPersonOptional = missingPersonRepository.findById(id);
    if (existingPersonOptional.isPresent()) {
        updatedMissingPerson.setId(id);
        missingPersonRepository.save(updatedMissingPerson);
        return true;
    }
    return false;
}

public boolean deleteMissingPerson(Long id) {
    Optional<MissingPerson> missingPersonOptional = missingPersonRepository.findById(id);
    if (missingPersonOptional.isPresent()) {
        missingPersonRepository.deleteById(id);
        return true;
    }
    return false;
}
}
