package com.service.exhibitservice.controller;

import com.service.exhibitservice.model.dto.recipe.request.ScrapCreateRequestDto;
import com.service.exhibitservice.model.dto.recipe.response.ScrapCreateResponseDto;
import com.service.exhibitservice.model.dto.recipe.response.ScrapDeleteResponseDto;
import com.service.exhibitservice.service.ExhibitRecipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "전시 레시피 연관 API")
public class ExhibitRecipeController {

    private final ExhibitRecipeService exhibitRecipeService;

    public ExhibitRecipeController(ExhibitRecipeService exhibitRecipeService) {
        this.exhibitRecipeService = exhibitRecipeService;
    }

    @PostMapping("scrap/recipe")
    @ApiOperation(value = "스크랩 생성", notes = "스크랩 생성 API")
    public ResponseEntity<ScrapCreateResponseDto> createScrap(ScrapCreateRequestDto scrapCreateRequestDto) {
        return ResponseEntity.ok(exhibitRecipeService.createScrap(scrapCreateRequestDto));
    }

    @DeleteMapping("scrap/recipe/{scrapId}")
    @ApiOperation(value = "스크랩 삭제", notes = "스크랩 삭제 API")
    public ResponseEntity<ScrapDeleteResponseDto> deleteScrap(@PathVariable Long scrapId) {
        return ResponseEntity.ok(exhibitRecipeService.deleteScrap(scrapId));
    }
}
