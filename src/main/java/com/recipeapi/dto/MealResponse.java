package com.recipeapi.dto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.recipeapi.dao.Meal;

@JsonAutoDetect(
		  fieldVisibility = Visibility.ANY,
		  getterVisibility = Visibility.NONE,
		  setterVisibility = Visibility.NONE,
		  creatorVisibility = Visibility.NONE
		)
@JsonPropertyOrder({"actCode","meals","errorCode","errorMessage"})
public class MealResponse extends Response{

	
	@JacksonXmlProperty(localName = "meal")
	@JacksonXmlElementWrapper(localName = "meals")
	private List<Meal> meals;

	
	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	@Override
	public String toString() {
		return "MealResponse [meals=" + meals + "]";
	}

	
}
