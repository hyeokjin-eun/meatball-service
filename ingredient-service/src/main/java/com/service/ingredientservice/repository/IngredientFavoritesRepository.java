package com.service.ingredientservice.repository;

import com.service.ingredientservice.model.entity.IngredientFavorites;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientFavoritesRepository extends JpaRepository<IngredientFavorites, Long> {

    List<IngredientFavorites> findByUserId(String userId);

    Optional<IngredientFavorites> findByIngredientSeqAndUserId(Long ingredientSeq, String userId);
}
