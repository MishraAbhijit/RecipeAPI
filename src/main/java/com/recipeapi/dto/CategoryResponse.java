package com.recipeapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.recipeapi.dao.Category;

@JsonPropertyOrder(alphabetic = true)
public class CategoryResponse extends Response {

	@JacksonXmlProperty(localName = "Category")
	@JacksonXmlElementWrapper(localName = "Categories")
	private List<Category> category;

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategoryResponse [category=" + category + "]";
	}

}
