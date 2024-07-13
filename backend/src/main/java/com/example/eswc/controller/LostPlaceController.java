package com.example.eswc.controller;

import com.example.eswc.model.LostPlace;
import com.example.eswc.service.LostPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lost-places")
public class LostPlaceController {

    @Autowired
    private LostPlaceService lostPlaceService;

    @PostMapping
    public ResponseEntity<String> registerLostPlace(@RequestBody LostPlace lostPlace) {
    lostPlaceService.registerLostPlace(lostPlace);
    return ResponseEntity.status(HttpStatus.CREATED).body("Lost place registered successfully!");
}

@GetMapping("/{id}")
public ResponseEntity<LostPlace> getLostPlaceById(@PathVariable Long id) {
    LostPlace lostPlace = lostPlaceService.getLostPlaceById(id);
    if (lostPlace == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(lostPlace);
}

@GetMapping
public ResponseEntity<List<LostPlace>> getAllLostPlaces() {
    List<LostPlace> lostPlaces = lostPlaceService.getAllLostPlaces();
    return ResponseEntity.ok(lostPlaces);
}

@PutMapping("/{id}")
public ResponseEntity<String> updateLostPlace(@PathVariable Long id, @RequestBody LostPlace updatedLostPlace) {
    boolean updated = lostPlaceService.updateLostPlace(id, updatedLostPlace);
    if (!updated) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("Lost place updated successfully");
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteLostPlace(@PathVariable Long id) {
    boolean deleted = lostPlaceService.deleteLostPlace(id);
    if (!deleted) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("Lost place deleted successfully");
}

}
