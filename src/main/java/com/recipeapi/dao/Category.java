package com.recipeapi.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Entity
@Table(name = "Category")
@XmlType(propOrder = {"Id","CategoryName"})
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	@JacksonXmlProperty(localName = "Id")
	private int idCategory;
	
	@Column(name = "CategoryName")
	@JacksonXmlProperty(localName = "CategoryName")
	private String strCategory;
	
	@Column(name = "CategoryThumb")
	@JacksonXmlProperty(localName = "CategoryThumb")
	private String strCategoryThumb;
	
	@Lob
	@Column(name = "CategoryDescription")
	@JacksonXmlProperty(localName = "CategoryDescription")
	private String strCategoryDescription;

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getStrCategory() {
		return strCategory;
	}

	public void setStrCategory(String strCategory) {
		this.strCategory = strCategory;
	}

	public String getStrCategoryThumb() {
		return strCategoryThumb;
	}

	public void setStrCategoryThumb(String strCategoryThumb) {
		this.strCategoryThumb = strCategoryThumb;
	}

	public String getStrCategoryDescription() {
		return strCategoryDescription;
	}

	public void setStrCategoryDescription(String strCategoryDescription) {
		this.strCategoryDescription = strCategoryDescription;
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", strCategory=" + strCategory + ", strCategoryThumb="
				+ strCategoryThumb + ", strCategoryDescription=" + strCategoryDescription + "]";
	}

}
