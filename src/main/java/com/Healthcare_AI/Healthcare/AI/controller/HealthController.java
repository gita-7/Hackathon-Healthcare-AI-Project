package com.Healthcare_AI.Healthcare.AI.controller;

import com.Healthcare_AI.Healthcare.AI.dto.RecommendationRequest;
import com.Healthcare_AI.Healthcare.AI.dto.SymptomCheckRequest;
import com.Healthcare_AI.Healthcare.AI.entity.HealthReport;
import com.Healthcare_AI.Healthcare.AI.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthController {

    @Autowired
    private HealthService healthService;
    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }
    @CrossOrigin
    @PostMapping("/symptom-checker")  // ✅ Correctly mapped to `/health/symptom-checker`
//    public ResponseEntity<String> analyzeSymptoms(@RequestBody SymptomCheckRequest request) {
//        String result = healthService.analyzeSymptoms(request);
//        return ResponseEntity.ok(result);
//    }
    public ResponseEntity<Map<String, String>> analyzeSymptoms(@RequestBody SymptomCheckRequest request) {
        String result = healthService.analyzeSymptoms(request);

        Map<String, String> response = new HashMap<>();
        response.put("message", result); // Ensure it's a JSON object

        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @GetMapping("/health-reports/{userId}")
    public ResponseEntity<List<HealthReport>> getHealthReports(@PathVariable Long userId) {
        List<HealthReport> reports = healthService.getHealthReports(userId);
        return ResponseEntity.ok(reports);
    }

    @CrossOrigin
    @PostMapping("/recommendations")
    public ResponseEntity<String> getRecommendations(@RequestBody RecommendationRequest request) {
        String recommendation = healthService.generateRecommendations(request);
        return ResponseEntity.ok(recommendation);
    }
    }
