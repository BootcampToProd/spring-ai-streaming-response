package com.bootcamptoprod.controller;

import com.bootcamptoprod.service.RecipeService;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * Streams recipe generation in real-time
     *
     * @param dishName - Name of dish (e.g., "Chicken Biryani")
     * @param servings - Number of servings (default: 4)
     * @return Streaming response of recipe content
     */
    @GetMapping(value = "/generate")
    public Flux<String> generateRecipe(@RequestParam String dishName, @RequestParam(defaultValue = "4") int servings) {
        // Call service to generate streaming recipe
        return recipeService.generateRecipeStream(dishName, servings);
    }

    /**
     * Endpoint with metadata
     */
    @GetMapping(value = "/generate-with-meta")
    public Flux<ChatClientResponse> generateRecipeWithMetadata(@RequestParam String dishName, @RequestParam(defaultValue = "4") int servings) {
        return recipeService.generateRecipeWithMetadata(dishName, servings);
    }
}