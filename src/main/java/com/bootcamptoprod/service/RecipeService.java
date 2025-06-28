package com.bootcamptoprod.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class RecipeService {

    private final ChatClient chatClient;

    // Constructor injection - Spring automatically provides ChatClient
    public RecipeService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * Generates a recipe using streaming response
     *
     * @param dishName - Name of the dish to generate recipe for
     * @param servings - Number of servings
     * @return Flux<String> - Stream of recipe content
     */
    public Flux<String> generateRecipeStream(String dishName, int servings) {
        // Create a detailed prompt for better recipe generation
        String prompt = String.format(
                "Generate a detailed recipe for %s that serves %d people. " +
                        "Include ingredients list, step-by-step cooking instructions, " +
                        "cooking time, and helpful tips. Format it nicely with clear sections.",
                dishName, servings
        );

        return chatClient.prompt()
                .user(prompt)  // Set user input
                .stream()      // Enable streaming
                .content();    // Return only content (not metadata)
    }

    /**
     * Generates recipe with metadata logging
     * This method shows how to access AI model usage statistics
     */
    public Flux<ChatClientResponse> generateRecipeWithMetadata(String dishName, int servings) {
        String prompt = String.format(
                "Create a recipe for %s serving %d people with ingredients and instructions.",
                dishName, servings
        );

        return chatClient.prompt()
                .user(prompt)
                .stream()
                .chatClientResponse();
    }
}
