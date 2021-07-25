package com.recipeapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeapi.dao.Ingredients;
import com.recipeapi.dto.IngredientResponse;
import com.recipeapi.repository.IngredientsRepository;

@Service
public class IngredientsService {

	@Autowired
	IngredientsRepository ingredientsRepository;
	
	public IngredientResponse getAll() {
		List<Ingredients> ingredients = ingredientsRepository.findAll();
		IngredientResponse response = new IngredientResponse();
		if(ingredients.size()>0)
		{
			response.setActCode("000");
			response.setIngredients(ingredients);
		}else {
			response.setActCode("111");
			response.setErrorCode("404");
			response.setErrorMessage("No Records Available");
		}
		return response;
	}

	public IngredientResponse addIngredient(Ingredients ingredients) {
		Ingredients ingredientsDBResponse = ingredientsRepository.save(ingredients);
		IngredientResponse response = new IngredientResponse();
		if(ingredientsDBResponse!=null)
		{
			response.setActCode("000");
			ArrayList<Ingredients> al= new ArrayList<>();
			al.add(ingredientsDBResponse);
			response.setIngredients(al);
		}else {
			response.setActCode("111");
			response.setErrorCode("201");
			response.setErrorMessage("Unable To Insert");
		}
		return response;
	}

	public IngredientResponse updateIngredient(Ingredients ingredients) {
		Ingredients ingredientsDBResponse = ingredientsRepository.save(ingredients);
		IngredientResponse response = new IngredientResponse();
		if(ingredientsDBResponse!=null)
		{
			response.setActCode("000");
			ArrayList<Ingredients> al= new ArrayList<>();
			al.add(ingredientsDBResponse);
			response.setIngredients(al);
		}else {
			response.setActCode("111");
			response.setErrorCode("201");
			response.setErrorMessage("Unable To Insert");
		}
		return response;
	}

	public IngredientResponse addBatchIngredient(List<Ingredients> ingredients) {
		List<Ingredients> ingredientsDBResponse = ingredientsRepository.saveAll(ingredients);
		IngredientResponse response = new IngredientResponse();
		if(ingredientsDBResponse!=null)
		{
			response.setActCode("000");
			response.setIngredients(ingredientsDBResponse);
		}else {
			response.setActCode("111");
			response.setErrorCode("201");
			response.setErrorMessage("Unable To Insert");
		}
		return response;
	}

}
