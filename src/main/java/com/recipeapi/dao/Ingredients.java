package com.recipeapi.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity
@Table(name = "Ingredients")

@JsonAutoDetect(
		  fieldVisibility = Visibility.ANY,
		  getterVisibility = Visibility.NONE,
		  setterVisibility = Visibility.NONE,
		  creatorVisibility = Visibility.NONE
		)

public class Ingredients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int idIngredient;
	
	@Column(name = "Name")
	private String strIngredient;
	
	@Column(name = "Description")
	@Lob
	private String strDescription;
	
	@Column(name = "Type")
	private String strType;

	public int getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}

	public String getStrIngredient() {
		return strIngredient;
	}

	public void setStrIngredient(String strIngredient) {
		this.strIngredient = strIngredient;
	}

	public String getStrDescription() {
		return strDescription;
	}

	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}

	public String getStrType() {
		return strType;
	}

	public void setStrType(String strType) {
		this.strType = strType;
	}

	@Override
	public String toString() {
		return "Ingredients [idIngredient=" + idIngredient + ", strIngredient=" + strIngredient + ", strDescription="
				+ strDescription + ", strType=" + strType + "]";
	}

}
