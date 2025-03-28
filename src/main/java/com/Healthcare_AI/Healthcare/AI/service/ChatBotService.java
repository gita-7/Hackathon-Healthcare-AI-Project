package com.Healthcare_AI.Healthcare.AI.service;

import com.Healthcare_AI.Healthcare.AI.dto.ChatBotRequest;
import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.core.credential.AzureKeyCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatChoice;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatRequestMessage;
import com.azure.ai.openai.models.ChatRequestSystemMessage;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import com.azure.ai.openai.models.ChatResponseMessage;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ChatBotService {
    @Value("${spring.ai.azure.openai.endpoint}")
    private String openAiEndpoint;

    @Value("${spring.ai.azure.openai.api-key}")
    private String openAiApiKey;

    @Value("${spring.ai.azure.openai.model}")
    private String openAiModel;

    private static final String MODEL_NAME = "gpt-4"; // Or "gpt-3.5-turbo"

    /*public String getAIResponse(ChatBotRequest request) {
        OpenAIClient client = new OpenAIClientBuilder()
                .endpoint(openAiEndpoint)
                .credential(new AzureKeyCredential(openAiApiKey))
                .buildClient();

        ChatCompletionsOptions options = new ChatCompletionsOptions(
                Collections.singletonList(new ChatRequestMessage(ChatRole.USER)));

        return client.getChatCompletions(MODEL_NAME, options)
                .getChoices().get(0).getMessage().getContent();
    }*/

    public String getAIResponse(ChatBotRequest request) {
        String apiKey = "A6k646HIIPAAkXG8pzxPbGsDcnBWeDF9N5O0uMPPuqtHMj8FtPgcJQQJ99BCACfhMk5XJ3w3AAAAACOGMUWk";
        String endpoint = "https://gitas-m8bb7jop-swedencentral.cognitiveservices.azure.com/";
        String model = "gpt-35-turbo-16k";
        String deploymentName = "gpt-35-turbo-16k";

        OpenAIClient client = new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(apiKey))
                .endpoint(endpoint)
                .buildClient();

        List<ChatRequestMessage> chatMessages = List.of(
                new ChatRequestSystemMessage(request.getQuestion())
        );

        ChatCompletionsOptions chatCompletionsOptions = new ChatCompletionsOptions(chatMessages);
        chatCompletionsOptions.setMaxTokens(1000);
        chatCompletionsOptions.setTemperature(1d);
        chatCompletionsOptions.setTopP(1d);
        chatCompletionsOptions.setModel(model);

        ChatCompletions chatCompletions = client.getChatCompletions(deploymentName, chatCompletionsOptions);

        System.out.printf("Model ID=%s is created at %s.%n", chatCompletions.getId(), chatCompletions.getCreatedAt());
        for (ChatChoice choice : chatCompletions.getChoices()) {
            ChatResponseMessage message = choice.getMessage();
            System.out.printf("Index: %d, Chat Role: %s.%n", choice.getIndex(), message.getRole());
            System.out.println("Message:");
            System.out.println(message.getContent());
        }

        return "Hello World!!!";
    }

}
