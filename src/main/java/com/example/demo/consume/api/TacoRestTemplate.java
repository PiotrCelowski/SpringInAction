package com.example.demo.consume.api;

import com.example.demo.domain.Ingredient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TacoRestTemplate {
    private RestTemplate rest;

    public TacoRestTemplate(RestTemplate rest) {
        this.rest = rest;
    }

    public Ingredient getIngredientById(String ingredientId) {
        return rest.getForObject("http://localhost:8080/ingredients/{id}",
                Ingredient.class, ingredientId);
    }

    public void updateIngredient(Ingredient ingredient) {
        rest.put("http://localhost:8080/ingredients/{id}",
                ingredient, ingredient.getId());
    }

}
