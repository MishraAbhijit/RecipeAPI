package com.recipeapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeapi.dao.Meal;
import com.recipeapi.dto.MealResponse;
import com.recipeapi.repository.MealsRepository;

@Service
public class MealsService {

	@Autowired
	MealsRepository mealsRepository;
	
	public List<Meal> findAllMeals() {
		System.out.println("------------------2-----------------");
		List<Meal> meals = mealsRepository.findAll();
		System.out.println("------------------3-----------------");
		meals.forEach(meal->System.out.println(meal));
		return meals;
	}

	public MealResponse addMeal(Meal meal) {
		Meal response = mealsRepository.save(meal);
		MealResponse mealResponse = new MealResponse();
		if(response != null)
		{
			mealResponse.setActCode("000");
			ArrayList<Meal> meals = new ArrayList<Meal>();
			meals.add(response);
			mealResponse.setMeals(meals);
		}
		return mealResponse;
	}

	public MealResponse findMealsByCountry(String countryName) {
		List<Meal> meals = mealsRepository.findByCountry(countryName);
		System.out.println("FindMealsByCountry DB Response Size :: "+meals.size());
		
		MealResponse mealResponse = new MealResponse();
		if(meals.size()>0)
		{
			mealResponse.setActCode("000");
			mealResponse.setMeals(meals);
		}else if(meals.size()==0)
		{
			mealResponse.setActCode("000");
			mealResponse.setMeals(meals);
		}
		
		System.out.println("FindMealsByCountry Response :: "+mealResponse);
		return mealResponse;
	}

	public MealResponse findMealsByCategory(String categoryName) {
		List<Meal> meals = mealsRepository.findByCategory(categoryName);
		System.out.println("findMealsByCategory DB Response Size :: "+meals.size());
		
		MealResponse mealResponse = new MealResponse();
		if(meals.size()>0)
		{
			mealResponse.setActCode("000");
			mealResponse.setMeals(meals);
		}else if(meals.size()==0)
		{
			mealResponse.setActCode("000");
			mealResponse.setMeals(meals);
		}
		
		System.out.println("findMealsByCategory Response :: "+mealResponse);
		return mealResponse;
	}

	public MealResponse findMealsByType(String mealType) {
		List<Meal> meals = mealsRepository.findByMealType(mealType);
		System.out.println("findMealsByType DB Response Size :: "+meals.size());
		
		MealResponse mealResponse = new MealResponse();
		if(meals.size()>0)
		{
			mealResponse.setActCode("000");
			mealResponse.setMeals(meals);
		}else if(meals.size()==0)
		{
			mealResponse.setActCode("000");
			mealResponse.setMeals(meals);
		}
		
		System.out.println("findMealsByType Response :: "+mealResponse);
		return mealResponse;
	}

	public MealResponse findMealByName(String mealName)
	{
		List<Meal> meals = mealsRepository.findByMealType(mealName);
		System.out.println("findMealByName DB Response Size :: "+meals.size());
		
		MealResponse mealResponse = new MealResponse();
		if(meals.size()>0)
		{
			mealResponse.setActCode("000");
			mealResponse.setMeals(meals);
		}else if(meals.size()==0)
		{
			mealResponse.setActCode("000");
			mealResponse.setMeals(meals);
		}
		
		System.out.println("findMealByName Response :: "+mealResponse);
		return mealResponse;
	}
	
	public MealResponse findMealById(String mealId)
	{
		Optional<Meal> mealresponse = mealsRepository.findById(mealId);
		Meal meal = mealresponse.get();
		System.out.println("findMealByName DB Response :: "+mealresponse);
		
		MealResponse mealResponse = new MealResponse();
		if(meal != null)
		{
			mealResponse.setActCode("000");
			ArrayList<Meal> meals = new ArrayList<Meal>();
			meals.add(meal);
			mealResponse.setMeals(meals);
		}
		
		System.out.println("findMealById Response :: "+mealResponse);
		return mealResponse;
	}

	public MealResponse addBatchMeal(List<Meal> meals) {
		List<Meal> mealDBResponse = mealsRepository.saveAll(meals);
		MealResponse mealResponse = new MealResponse();
		
		if(mealDBResponse.size()>0)
		{
			mealResponse.setActCode("000");
			mealResponse.setMeals(mealDBResponse);
		}else {
			mealResponse.setActCode("123");
		}
		
		return mealResponse;
	}
}
