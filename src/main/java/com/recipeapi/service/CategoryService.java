package com.recipeapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeapi.dao.Category;
import com.recipeapi.dto.CategoryResponse;
import com.recipeapi.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryResponse addCategory(Category category) {
		Category categoryDBResponse = categoryRepository.save(category);
		System.out.println("CategoryDBResponse :: "+categoryDBResponse);
		
		CategoryResponse categoryResponse=new CategoryResponse();
		if(categoryDBResponse!=null)
		{
			categoryResponse.setActCode("000");
			ArrayList<Category> arrayList = new ArrayList<Category>();
			arrayList.add(categoryDBResponse);
			categoryResponse.setCategory(arrayList);
		}else {
			categoryResponse.setActCode("123");
		}
		
		System.out.println("CategoryResponse :: "+categoryResponse);
		return categoryResponse;
	}

	public CategoryResponse getCategories() {
		List<Category> categories = categoryRepository.findAll();
		CategoryResponse categoryResponse=new CategoryResponse();
		if(categories!=null)
		{
			categoryResponse.setActCode("000");
			categoryResponse.setCategory(categories);
		}else {
			categoryResponse.setActCode("123");
		}
		return categoryResponse;
	}

	public CategoryResponse getCategoryByName(String categoryName) {
		Category category = categoryRepository.findByStrCategory(categoryName);
		System.out.println("getCategoryByName DB Response :: "+category);
		CategoryResponse categoryResponse=new CategoryResponse();
		if(category!=null)
		{
			categoryResponse.setActCode("000");
			ArrayList<Category> arrayList = new ArrayList<Category>();
			arrayList.add(category);
			categoryResponse.setCategory(arrayList);
		}else {
			categoryResponse.setActCode("123");
		}
		
		System.out.println("getCategoryByName Response :: "+categoryResponse);
		return categoryResponse;
	}

	public CategoryResponse addBatchCategory(List<Category> categories) {
		List<Category> categoriesDBResponse = categoryRepository.saveAll(categories);
		CategoryResponse categoryResponse = new CategoryResponse();
		if(categoriesDBResponse.size()>0)
		{
			categoryResponse.setActCode("000");
			categoryResponse.setCategory(categories);
		}else {
			categoryResponse.setActCode("123");
		}
		return categoryResponse;
	}

}
