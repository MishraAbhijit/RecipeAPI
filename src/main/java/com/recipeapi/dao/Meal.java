package com.recipeapi.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.recipeapi.dto.Ingredient;

@Document(collection = "Meals")

@JsonAutoDetect(
		  fieldVisibility = Visibility.ANY,
		  getterVisibility = Visibility.NONE,
		  setterVisibility = Visibility.NONE,
		  creatorVisibility = Visibility.NONE
		)
@JsonPropertyOrder({"id","name","country","category","mealType","mealThumb","tags","youtubeLinks","ingredients",
	"instructions","createdDate","updatedDate"})
public class Meal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	@Indexed(unique = true)
	private String name;
	private String country;
	private String category;
	private String mealType;
	private String mealThumb;
	/*
	 * @XmlElementWrapper(name = "tags")
	 * 
	 * @XmlElement(name = "tag")
	 */
	@JacksonXmlElementWrapper(localName = "tags")
	@JacksonXmlProperty(localName = "tag")
	private List<String> tags;
	
	@JacksonXmlElementWrapper(localName = "youtubelinks")
	@JacksonXmlProperty(localName = "link")
	private List<String> youtubeLinks;
	
	@JacksonXmlElementWrapper(localName = "ingredients")
	@JacksonXmlProperty(localName = "ingredient")
	private List<Ingredient> ingredients;
	
	@JacksonXmlElementWrapper(localName = "instructions")
	@JacksonXmlProperty(localName = "instruction")
	private List<String> instructions;
	
	private String createdDate;
	private String updatedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getMealThumb() {
		return mealThumb;
	}

	public void setMealThumb(String mealThumb) {
		this.mealThumb = mealThumb;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getYoutubeLinks() {
		return youtubeLinks;
	}

	public void setYoutubeLinks(List<String> youtubeLinks) {
		this.youtubeLinks = youtubeLinks;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Meal [id=" + id + ", name=" + name + ", country=" + country + ", category=" + category + ", mealType="
				+ mealType + ", mealThumb=" + mealThumb + ", tags=" + tags + ", youtubeLinks=" + youtubeLinks
				+ ", ingredients=" + ingredients + ", instructions=" + instructions + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

	
}