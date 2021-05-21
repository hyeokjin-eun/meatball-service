package com.service.exhibitservice.service;

import com.service.exhibitservice.exception.ScrapRecipeNotFoundException;
import com.service.exhibitservice.model.dto.recipe.request.ScrapCreateRequestDto;
import com.service.exhibitservice.model.dto.recipe.response.ScrapCreateResponseDto;
import com.service.exhibitservice.model.dto.recipe.response.ScrapDeleteResponseDto;
import com.service.exhibitservice.model.entity.ScrapRecipe;
import com.service.exhibitservice.repository.ScrapRecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExhibitRecipeService {

    private final ScrapRecipeRepository scrapRecipeRepository;

    public ExhibitRecipeService(ScrapRecipeRepository scrapRecipeRepository) {
        this.scrapRecipeRepository = scrapRecipeRepository;
    }

    /**
     * 스크랩 생성
     * @param scrapCreateRequestDto 스크랩 생성 Request Dto
     * @return ScrapCreateResponseDto
     */
    public ScrapCreateResponseDto createScrap(ScrapCreateRequestDto scrapCreateRequestDto) {
        return Optional.of(scrapRecipeRepository.save(ScrapRecipe.builder()
                .scrapId(scrapCreateRequestDto.getScrapId())
                .recipeId(scrapCreateRequestDto.getRecipeId())
                .userId(scrapCreateRequestDto.getUserId())
                .build()))
                .map(scrapRecipe -> ScrapCreateResponseDto.builder()
                        .scrapId(scrapRecipe.getScrapId())
                        .recipeId(scrapRecipe.getRecipeId())
                        .userId(scrapRecipe.getUserId())
                        .build())
                .orElseThrow(ScrapRecipeNotFoundException::new);
    }

    /**
     * 스크랩 삭제
     * @param scrapId 스크랩 식별자
     * @return ScrapDeleteResponseDto
     */
    public ScrapDeleteResponseDto deleteScrap(Long scrapId) {
        return scrapRecipeRepository.findByScrapId(scrapId)
                .map(scrapRecipe -> {
                    scrapRecipeRepository.delete(scrapRecipe);
                    return ScrapDeleteResponseDto.builder()
                            .scrapId(scrapRecipe.getScrapId())
                            .recipeId(scrapRecipe.getRecipeId())
                            .userId(scrapRecipe.getUserId())
                            .build();
                })
                .orElseThrow(ScrapRecipeNotFoundException::new);
    }
}
