package com.recipeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipeapi.dao.Ingredients;
import com.recipeapi.dto.IngredientResponse;
import com.recipeapi.service.IngredientsService;

@RestController
@RequestMapping("/ingredients")
public class IngridientsController {

	@Autowired
	IngredientsService ingredientsService;

	// show all ingredients
	@GetMapping(value = "/all/", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public IngredientResponse getAllIngredients() {
		IngredientResponse ingredientResponse = ingredientsService.getAll();
		return ingredientResponse;
	}

	// add ingredient
	@PostMapping(value = "/add/", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public IngredientResponse addIngredient(@RequestBody Ingredients ingredients) {
		IngredientResponse ingredientResponse = ingredientsService.addIngredient(ingredients);
		return ingredientResponse;
	}

	// update ingredient
	@PutMapping(value = "/update/", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public IngredientResponse updateIngredient(@RequestBody Ingredients ingredients) {
		IngredientResponse ingredientResponse = ingredientsService.updateIngredient(ingredients);
		return ingredientResponse;
	}

	// add batch ingredient
	@PostMapping(value = "/add/batch/", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public IngredientResponse addBatchIngredient(@RequestBody List<Ingredients> ingredients) {
		IngredientResponse ingredientResponse = ingredientsService.addBatchIngredient(ingredients);
		return ingredientResponse;
	}
}
