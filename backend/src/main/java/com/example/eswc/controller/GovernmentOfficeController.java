package com.example.eswc.controller;

import com.example.eswc.model.GovernmentOffice;
import com.example.eswc.service.GovernmentOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/government-offices")
public class GovernmentOfficeController {

    @Autowired
    private GovernmentOfficeService governmentOfficeService;

    @PostMapping
    public ResponseEntity<String> registerGovernmentOffice(@RequestBody GovernmentOffice governmentOffice) {
    governmentOfficeService.registerGovernmentOffice(governmentOffice);
    return ResponseEntity.status(HttpStatus.CREATED).body("Government office registered successfully!");
}

@GetMapping("/{id}")
public ResponseEntity<GovernmentOffice> getGovernmentOfficeById(@PathVariable Long id) {
    GovernmentOffice governmentOffice = governmentOfficeService.getGovernmentOfficeById(id);
    if (governmentOffice == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(governmentOffice);
}

@GetMapping
public ResponseEntity<List<GovernmentOffice>> getAllGovernmentOffices() {
    List<GovernmentOffice> governmentOffices = governmentOfficeService.getAllGovernmentOffices();
    return ResponseEntity.ok(governmentOffices);
}

@PutMapping("/{id}")
public ResponseEntity<String> updateGovernmentOffice(@PathVariable Long id, @RequestBody GovernmentOffice updatedGovernmentOffice) {
    boolean updated = governmentOfficeService.updateGovernmentOffice(id, updatedGovernmentOffice);
    if (!updated) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("Government office updated successfully");
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteGovernmentOffice(@PathVariable Long id) {
    boolean deleted = governmentOfficeService.deleteGovernmentOffice(id);
    if (!deleted) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("Government office deleted successfully");
}
}
