package com.recipeapi.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "ingredient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ingredient {

	private String name;
	private String quantity;

	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ingredient(String name, String quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", quantity=" + quantity + "]";
	}

	
}
