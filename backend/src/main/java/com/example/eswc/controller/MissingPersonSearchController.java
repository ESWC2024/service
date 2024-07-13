package com.example.eswc.controller;

import com.example.eswc.dto.SearchCriteriaDTO;
import com.example.eswc.model.MissingPerson;
import com.example.eswc.service.MissingPersonSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missing-persons/search")
public class MissingPersonSearchController {

    @Autowired
    private MissingPersonSearchService missingPersonSearchService;

    @PostMapping
    public ResponseEntity<List<MissingPerson>> searchMissingPersons(@RequestBody SearchCriteriaDTO searchCriteria) {
    List<MissingPerson> missingPersons = missingPersonSearchService.searchMissingPersons(searchCriteria);
    return ResponseEntity.ok(missingPersons);
}
}
