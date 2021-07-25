package com.recipeapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipeapi.dao.Meal;

@Repository
public interface MealsRepository extends MongoRepository<Meal, String> {

	// find nested query
	// find by ingredient name
	@Query(fields = "{'id':1,'name':1,'mealThumb':1}")
	List<Meal> findByIngredients_Name(String name);

	// find by name
	List<Meal> findByName(String name);
	
	// find all meal by first letter

	Optional<Meal> findById(String id);
	
	// single random meal

	// list all meal categories

	// list all categories

	// list all area

	// list all ingredients

	// filter by main ingredient

	// filter by category
	List<Meal> findByCategory(String categoryName);

	// filter by area
	List<Meal> findByCountry(String countryName);

	// filter by meal type
	List<Meal> findByMealType(String mealType);

	// filter by multiple ingredient
}
