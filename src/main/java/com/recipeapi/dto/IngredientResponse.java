package com.recipeapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.recipeapi.dao.Ingredients;

@JsonPropertyOrder({"actCode","ingredients","errorCode","errorMessage"})
//@JsonPropertyOrder(alphabetic = true)
public class IngredientResponse extends Response{

	@JacksonXmlProperty(localName = "Ingredient")
	@JacksonXmlElementWrapper(localName = "Ingredients")
	private List<Ingredients> ingredients;

	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "IngredientResponse [ingredients=" + ingredients + "]";
	}

}
