package com.example.eswc.controller;
import com.example.eswc.model.MissingPerson;
import com.example.eswc.service.MissingPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missing-persons")
public class MissingPersonController {

    @Autowired
    private MissingPersonService missingPersonService;

    @PostMapping
    public ResponseEntity<String> registerMissingPerson(@RequestBody MissingPerson missingPerson) {
    missingPersonService.registerMissingPerson(missingPerson);
    return ResponseEntity.status(HttpStatus.CREATED).body("Missing person registered successfully!");
}

@GetMapping("/{id}")
public ResponseEntity<MissingPerson> getMissingPersonById(@PathVariable Long id) {
    MissingPerson missingPerson = missingPersonService.getMissingPersonById(id);
    if (missingPerson == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(missingPerson);
}

@GetMapping
public ResponseEntity<List<MissingPerson>> getAllMissingPersons() {
    List<MissingPerson> missingPersons = missingPersonService.getAllMissingPersons();
    return ResponseEntity.ok(missingPersons);
}

@PutMapping("/{id}")
public ResponseEntity<String> updateMissingPerson(@PathVariable Long id, @RequestBody MissingPerson updatedMissingPerson) {
    boolean updated = missingPersonService.updateMissingPerson(id, updatedMissingPerson);
    if (!updated) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("Missing person updated successfully");
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteMissingPerson(@PathVariable Long id) {
    boolean deleted = missingPersonService.deleteMissingPerson(id);
    if (!deleted) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("Missing person deleted successfully");
}
}
