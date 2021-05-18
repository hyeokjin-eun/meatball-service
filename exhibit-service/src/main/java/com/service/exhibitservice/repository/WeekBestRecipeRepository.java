package com.service.exhibitservice.repository;

import com.service.exhibitservice.model.entity.WeekBestRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekBestRecipeRepository extends JpaRepository<WeekBestRecipe, Long> {
}
