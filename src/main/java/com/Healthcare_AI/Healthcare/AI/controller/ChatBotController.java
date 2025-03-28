package com.Healthcare_AI.Healthcare.AI.controller;

import com.Healthcare_AI.Healthcare.AI.dto.ChatBotRequest;
import com.Healthcare_AI.Healthcare.AI.service.ChatBotService;
import com.Healthcare_AI.Healthcare.AI.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatbot")
public class ChatBotController {
    @Autowired
    private ChatBotService chatbotService;

    @Autowired
    private HealthService healthService;

    @CrossOrigin
    @PostMapping("/query")
    public ResponseEntity<String> askChatbot(@RequestBody ChatBotRequest request) {
        String response = chatbotService.getAIResponse(request);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/query")
//    public ResponseEntity<String> askChatbot(@RequestBody String userMessage) {
//        String response = healthService.analyzeSymptoms(userMessage);
//        return ResponseEntity.ok(response);
//    }
}
