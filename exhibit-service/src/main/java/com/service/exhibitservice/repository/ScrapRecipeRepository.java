package com.service.exhibitservice.repository;

import com.service.exhibitservice.model.entity.ScrapRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScrapRecipeRepository extends JpaRepository<ScrapRecipe, Long> {

    Optional<ScrapRecipe> findByScrapId(Long scrapId);
}
