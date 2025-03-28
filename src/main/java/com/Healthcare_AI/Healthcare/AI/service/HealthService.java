package com.Healthcare_AI.Healthcare.AI.service;

import com.Healthcare_AI.Healthcare.AI.dto.RecommendationRequest;
import com.Healthcare_AI.Healthcare.AI.dto.SymptomCheckRequest;
import com.Healthcare_AI.Healthcare.AI.entity.HealthRecommendation;
import com.Healthcare_AI.Healthcare.AI.entity.HealthReport;
import com.Healthcare_AI.Healthcare.AI.repository.HealthRecommendationRepository;
import com.Healthcare_AI.Healthcare.AI.repository.HealthReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

    @Service
    public class HealthService {

        @Autowired
        private HealthReportRepository healthReportRepository;

        @Autowired
        private HealthRecommendationRepository recommendationRepository;

      //  private final OpenAIClient openAIClient;

//        public HealthService(@Value("${azure.openai.api.key}") String apiKey) {
//            this.openAIClient = new OpenAIClient(apiKey, "https://api.openai.com/v1/");
//        }
//
//        public String analyzeSymptoms(String symptoms) {
//            List<ChatMessage> messages = Collections.singletonList(new ChatMessage("user", "Analyze the symptoms: " + symptoms));
//            ChatCompletionsOptions options = new ChatCompletionsOptions(messages);
//            return openAIClient.getChatCompletions("gpt-4", options).getChoices().get(0).getMessage().getContent();
//        }
        public String analyzeSymptoms(SymptomCheckRequest request) {
            // Here, integrate Azure Health Bot or OpenAI for AI-based analysis
            String aiResponse = "Based on the symptoms provided, please consult a doctor if symptoms persist.";

            // Save health report
            HealthReport report = new HealthReport();
            report.setUserId(request.getUserId());
            report.setHealthData("Symptoms: " + request.getSymptoms() + " | AI Response: " + aiResponse);
            report.setReportDate(new Date());
            healthReportRepository.save(report);

            return aiResponse;
        }

        public List<HealthReport> getHealthReports(Long userId) {
            return healthReportRepository.findByUserId(userId);
        }

        public String generateRecommendations(RecommendationRequest request) {
            // Simulating AI-powered recommendation logic
            String recommendation = "Drink plenty of water and maintain a balanced diet.";

            // Save recommendation
            HealthRecommendation healthRecommendation = new HealthRecommendation();
            healthRecommendation.setUserId(request.getUserId());
            healthRecommendation.setRecommendation(recommendation);
            recommendationRepository.save(healthRecommendation);

            return recommendation;
        }
    }
