package com.example.eswc.controller;

import com.example.eswc.model.Guardian;
import com.example.eswc.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guardians")
public class GuardianController {

    @Autowired
    private GuardianService guardianService;

    @PostMapping
    public ResponseEntity<String> registerGuardian(@RequestBody Guardian guardian) {
        Guardian addedGuardian = guardianService.addGuardian(guardian);
        return ResponseEntity.status(HttpStatus.CREATED).body("Guardian registered successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guardian> getGuardianById(@PathVariable Long id) {
        Guardian guardian = guardianService.getGuardianById(id);
        if (guardian == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(guardian);
    }

    @GetMapping
    public ResponseEntity<List<Guardian>> getAllGuardians() {
        List<Guardian> guardians = guardianService.getAllGuardians();
        return ResponseEntity.ok(guardians);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGuardian(@PathVariable Long id, @RequestBody Guardian updatedGuardian) {
        boolean updated = guardianService.updateGuardian(id, updatedGuardian);
        if (!updated) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Guardian updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuardian(@PathVariable Long id) {
        boolean deleted = guardianService.deleteGuardian(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Guardian deleted successfully");
    }
}
