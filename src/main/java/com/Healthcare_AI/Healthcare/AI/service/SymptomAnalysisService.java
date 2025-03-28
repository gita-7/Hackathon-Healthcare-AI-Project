//package com.Healthcare_AI.Healthcare.AI.service;
//
//import com.Healthcare_AI.Healthcare.AI.dto.SymptomCheckRequest;
//import com.Healthcare_AI.Healthcare.AI.entity.HealthReport;
//import com.Healthcare_AI.Healthcare.AI.repository.HealthReportRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.http.*;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class SymptomAnalysisService {
//
//    @Value("${azure.openai.endpoint}")
//    private String azureOpenAiEndpoint;
//
//    @Value("${azure.openai.apiKey}")
//    private String azureOpenAiApiKey;
//
//    private final HealthReportRepository healthReportRepository;
//    private final RestTemplate restTemplate;
//
//    public SymptomAnalysisService(HealthReportRepository healthReportRepository, RestTemplate restTemplate) {
//        this.healthReportRepository = healthReportRepository;
//        this.restTemplate = restTemplate;
//    }
//
//    public String analyzeSymptoms(SymptomCheckRequest request) {
//        // Call Azure OpenAI to get AI-based analysis
//        String aiResponse = getAiAnalysis(request.getSymptoms());
//
//        // Save health report
//        HealthReport report = new HealthReport();
//        report.setUserId(request.getUserId());
//        report.setHealthData("Symptoms: " + request.getSymptoms() + " | AI Response: " + aiResponse);
//        report.setReportDate(new Date());
//        healthReportRepository.save(report);
//
//        return aiResponse;
//    }
//
//    private String getAiAnalysis(String symptoms) {
//        // Prepare request payload
//        Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("model", "gpt-4");
//        requestBody.put("messages", new Object[]{
//                new HashMap<String, String>() {{
//                    put("role", "system");
//                    put("content", "You are a medical AI assistant. Provide concise health advice based on symptoms.");
//                }},
//                new HashMap<String, String>() {{
//                    put("role", "user");
//                    put("content", symptoms);
//                }}
//        });
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", "Bearer " + azureOpenAiApiKey);
//
//        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
//
//        try {
//            ResponseEntity<Map> response = restTemplate.exchange(
//                    azureOpenAiEndpoint + "/v1/chat/completions",
//                    HttpMethod.POST,
//                    requestEntity,
//                    Map.class
//            );
//
//            Map responseBody = response.getBody();
//            if (responseBody != null && responseBody.containsKey("choices")) {
//                return ((Map<String, Object>) ((Map[]) responseBody.get("choices"))[0].get("message")).get("content").toString();
//            }
//        } catch (Exception e) {
//            return "Unable to analyze symptoms at this time. Please try again later.";
//        }
//
//        return "No response from AI.";
//    }
//}
