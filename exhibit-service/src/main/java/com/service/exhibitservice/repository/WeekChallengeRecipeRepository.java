package com.service.exhibitservice.repository;

import com.service.exhibitservice.model.entity.WeekChallengeRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekChallengeRecipeRepository extends JpaRepository<WeekChallengeRecipe, Long> {
}
