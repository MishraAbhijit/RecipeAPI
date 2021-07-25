package com.recipeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipeapi.dao.Meal;
import com.recipeapi.dto.MealResponse;
import com.recipeapi.service.MealsService;

@RestController
@RequestMapping("/meals")
public class MealsController {

	@Autowired
	MealsService mealsService;

	//find all recipes
	@GetMapping(value = "/", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MealResponse findAll() {
		System.out.println("-------------1-------------");
		List<Meal> meals = mealsService.findAllMeals();
		MealResponse mealResponse = new MealResponse();
		mealResponse.setActCode("000");
		mealResponse.setMeals(meals);
		return mealResponse;
	}

	@PostMapping(value="/addMeal",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MealResponse addMeal(@RequestBody Meal meal)
	{
		System.out.println("-------------- adding ---------------");
		System.out.println(meal);
		MealResponse mealResponse = mealsService.addMeal(meal);
		return mealResponse;
	}
	
	
	//add batch meals
	@PostMapping(value="/addMeal/batch",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MealResponse addBatchMeal(@RequestBody List<Meal> meals)
	{
		System.out.println("-------------- adding ---------------");
		System.out.println(meals.size());
		MealResponse mealResponse = mealsService.addBatchMeal(meals);
		return mealResponse;
	}
	
	//find recipes by country
	@GetMapping(value = "/country", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MealResponse findMealsByCountry(@RequestParam("a") String countryName) {
		System.out.println("------------ Find Meals By Country --------------- :: "+countryName);
		MealResponse mealResponse = mealsService.findMealsByCountry(countryName);
		return mealResponse;
	}
	
	//find recipes by category
	@GetMapping(value = "/category", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MealResponse findMealsByCategory(@RequestParam("c") String categoryName) {
		System.out.println("------------ Find Meals By Category --------------- :: "+categoryName);
		MealResponse mealResponse = mealsService.findMealsByCategory(categoryName);
		return mealResponse;
	}
	
	// find recipes by meal type
	@GetMapping(value = "/meal", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public MealResponse findMealsByMealType(@RequestParam("type") String mealType) {
		System.out.println("------------ Find Meals By Category --------------- :: " + mealType);
		MealResponse mealResponse = mealsService.findMealsByType(mealType);
		return mealResponse;
	}
}
