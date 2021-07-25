package com.recipeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipeapi.dao.Category;
import com.recipeapi.dto.CategoryResponse;
import com.recipeapi.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping(value = "/add/", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CategoryResponse addCategory(@RequestBody Category category) {
		CategoryResponse categoryResponse = categoryService.addCategory(category);
		return categoryResponse;
	}

	//add batch categories
	@PostMapping(value = "/add/batch", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CategoryResponse addBatchCategory(@RequestBody List<Category> categories) {
		CategoryResponse categoryResponse = categoryService.addBatchCategory(categories);
		return categoryResponse;
	}
	@GetMapping(value = "/all/", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CategoryResponse getCategories() {
		CategoryResponse categoryResponse = categoryService.getCategories();
		return categoryResponse;
	}
	
	@GetMapping(value = "/cat", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CategoryResponse getCategoryByName(@RequestParam("cname")String categoryName) {
		CategoryResponse categoryResponse = categoryService.getCategoryByName(categoryName);
		return categoryResponse;
	}
	
}
