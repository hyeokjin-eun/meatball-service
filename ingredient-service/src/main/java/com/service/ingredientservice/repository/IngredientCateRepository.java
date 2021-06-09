package com.service.ingredientservice.repository;

import com.service.ingredientservice.model.entity.IngredientCate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientCateRepository extends JpaRepository<IngredientCate, Long> {
}
