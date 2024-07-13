package com.example.eswc.controller;

import com.example.eswc.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIServiceController {

    @Autowired
    private AIService aiService;

    @PostMapping("/api/ai/find-missing-person")
    public ResponseEntity<String> findMissingPersonByImage(@RequestBody byte[] imageBytes) {
    String result = aiService.findMissingPersonByImage(imageBytes);
    return ResponseEntity.status(HttpStatus.OK).body(result);
}

}
