package com.recipeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipeapi.dao.Ingredients;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

}
