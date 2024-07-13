package com.example.eswc.service;

import com.example.eswc.dto.SearchCriteriaDTO;
import com.example.eswc.model.MissingPerson;
import com.example.eswc.repository.MissingPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissingPersonSearchService {

    @Autowired
    private MissingPersonRepository missingPersonRepository;

    public List<MissingPerson> searchMissingPersons(SearchCriteriaDTO searchCriteria) {
        String name = searchCriteria.getName();
        String gender = searchCriteria.getGender();
        String lastSeenLocation = searchCriteria.getLastSeenLocation();

        // Implement search logic based on the criteria
        if (name != null && gender != null && lastSeenLocation != null) {
            // Search by all criteria
            return missingPersonRepository.findByNameAndGenderAndLastSeenLocation(name, gender, lastSeenLocation);
        } else if (name != null && gender != null) {
            // Search by name and gender
            return missingPersonRepository.findByNameAndGender(name, gender);
        } else if (name != null && lastSeenLocation != null) {
            // Search by name and last seen location
            return missingPersonRepository.findByNameAndLastSeenLocation(name, lastSeenLocation);
        } else if (gender != null && lastSeenLocation != null) {
            // Search by gender and last seen location
            return missingPersonRepository.findByGenderAndLastSeenLocation(gender, lastSeenLocation);
        } else if (name != null) {
            // Search by name only
            return missingPersonRepository.findByName(name);
        } else if (gender != null) {
            // Search by gender only
            return missingPersonRepository.findByGender(gender);
        } else if (lastSeenLocation != null) {
            // Search by last seen location only
            return missingPersonRepository.findByLastSeenLocation(lastSeenLocation);
        } else {
            // No criteria provided, return all missing persons
            return missingPersonRepository.findAll();
        }
    }
}
