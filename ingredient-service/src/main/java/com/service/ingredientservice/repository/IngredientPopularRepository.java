package com.service.ingredientservice.repository;

import com.service.ingredientservice.model.entity.IngredientPopular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientPopularRepository extends JpaRepository<IngredientPopular, Long> {

    Optional<IngredientPopular> findByIngredientSeq(Long ingredientSeq);
}
