package com.recipeapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.recipeapi.dao.Meal;
import com.recipeapi.dto.Ingredient;
import com.recipeapi.repository.MealsRepository;

@SpringBootTest
class RecipeApiApplicationTests {

	@Autowired
	MealsRepository mealsRepository;
	
	@Test
	void contextLoads() {
	}

	@Test
	void addMeals() {
		Meal meal = new Meal();
		meal.setName("Chicken Handi");
		meal.setCountry("India");
		meal.setCategory("MainCourse");
		meal.setMealType("NonVeg");
		meal.setMealThumb("https://www.themealdb.com/images/media/meals/wyxwsp1486979827.jpg");
		
		List<String> tags = new ArrayList<>();
		tags.add("Chicken");
		tags.add("Indian");
		tags.add("MainCourse");
		tags.add("Onion");
		
		List<String> youtubeLinks = new ArrayList<String>();
		youtubeLinks.add("https://www.youtube.com/watch?v=IO0issT0Rmc");
		
		Ingredient ingredient1 = new Ingredient("Chicken", "1.2 kg");
		Ingredient ingredient2 = new Ingredient("Onion", "5 thinly sliced");
		Ingredient ingredient3 = new Ingredient("Tomatoes", "2 finely chopped");
		Ingredient ingredient4 = new Ingredient("Garlic", "8 cloves chopped");
		Ingredient ingredient5 = new Ingredient("Ginger paste", "1 tbsp");
		Ingredient ingredient6 = new Ingredient("Vegetable oil", "1/4 cup");
		Ingredient ingredient7 = new Ingredient("Cumin seeds", "2 tsp");
		Ingredient ingredient8 = new Ingredient("Coriander seeds", "3 tsp");
		Ingredient ingredient9 = new Ingredient("Turmeric powder", "1 tsp");
		Ingredient ingredient10 = new Ingredient("Chilli powder", "1 tsp");
		Ingredient ingredient11 = new Ingredient("Green chilli", "2");
		Ingredient ingredient12 = new Ingredient("Yogurt", "1 cup");
		Ingredient ingredient13 = new Ingredient("Cream", "3/4 cup");
		Ingredient ingredient14 = new Ingredient("fenugreek", "3 tsp Dried");
		Ingredient ingredient15 = new Ingredient("Garam masala", "1 tsp");
		Ingredient ingredient16 = new Ingredient("Salt", "To taste");
		
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(ingredient1);
		ingredients.add(ingredient2);
		ingredients.add(ingredient3);
		ingredients.add(ingredient4);
		ingredients.add(ingredient5);
		ingredients.add(ingredient6);
		ingredients.add(ingredient7);
		ingredients.add(ingredient8);
		ingredients.add(ingredient9);
		ingredients.add(ingredient10);
		ingredients.add(ingredient11);
		ingredients.add(ingredient12);
		ingredients.add(ingredient13);
		ingredients.add(ingredient14);
		ingredients.add(ingredient15);
		ingredients.add(ingredient16);
		
		List<String> instructions = new ArrayList<String>();
		instructions.add("Take a large pot or wok, big enough to cook all the chicken, and heat the oil in it.");
		instructions.add("Once the oil is hot, add sliced onion and fry them until deep golden brown.");
		instructions.add("Then take them out on a plate and set aside.");
		instructions.add("To the same pot, add the chopped garlic and sauté for a minute.");
		instructions.add("Then add the chopped tomatoes and cook until tomatoes turn soft. This would take about 5 minutes");
		instructions.add("Then return the fried onion to the pot and stir.");
		instructions.add("Add ginger paste and sauté well. Now add the cumin seeds, half of the coriander seeds and chopped green chillies. Give them a quick stir.");
		instructions.add("Next goes in the spices – turmeric powder and red chilli powder. Sauté the spices well for couple of minutes.");
		instructions.add("Add the chicken pieces to the wok, season it with salt to taste and cook the chicken covered on medium-low heat until the chicken is almost cooked through. This would take about 15 minutes.");
		instructions.add("Slowly sautéing the chicken will enhance the flavor, so do not expedite this step by putting it on high heat.");
		instructions.add("When the oil separates from the spices, add the beaten yogurt keeping the heat on lowest so that the yogurt doesn’t split.");
		instructions.add("Sprinkle the remaining coriander seeds and add half of the dried fenugreek leaves. Mix well.");
		instructions.add("Finally add the cream and give a final mix to combine everything well.");
		instructions.add("Sprinkle the remaining kasuri methi and garam masala and serve the chicken handi hot with naan or rotis.");
		instructions.add("Enjoy!");
		
		
		meal.setTags(tags);
		meal.setYoutubeLinks(youtubeLinks);
		meal.setIngredients(ingredients);
		meal.setInstructions(instructions);
		meal.setCreatedDate("06-06-2021");
		meal.setUpdatedDate("");
		
		Meal meals = mealsRepository.save(meal);
		
		assertNotNull(meals);
	}
	
	@Test
	public void testResult()
	{
		List<Meal> list = mealsRepository.findAll();
		list.forEach(l->System.out.println(l));
		System.out.println(list.size());
	}
	
	@Test
	public void findBYIngredient()
	{
		List<Meal> list = mealsRepository.findByIngredients_Name("Onion");
		list.forEach(meal->System.out.println(meal));
		System.out.println(list.size());
	}
}
