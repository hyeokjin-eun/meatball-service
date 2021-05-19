package com.service.exhibitservice.controller;

import com.service.exhibitservice.model.dto.*;
import com.service.exhibitservice.service.ExhibitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exhibitservice")
public class ExhibitController {

    private final ExhibitService exhibitService;

    public ExhibitController(ExhibitService exhibitService) {
        this.exhibitService = exhibitService;
    }

    @GetMapping("user/time/recipe")
    @ApiOperation(value = "시간별 레시피 추천 데이터", notes = "임시 데이터 출력")
    public ResponseEntity<UserTimeRecommendResponseDto> getUserTimeRecommendRecipe() {
        return ResponseEntity.ok(exhibitService.getUserTimeRecommendRecipe());
    }

    @GetMapping("user/week/challenge")
    @ApiOperation(value = "이번주 도전 요리", notes = "스크랩 부분 추가 수정 예정")
    public ResponseEntity<List<WeeklyChallengeRecipeResponseDto>> getWeeklyChallengeRecipe() {
        return ResponseEntity.ok(exhibitService.getWeeklyChallengeRecipe());
    }

    @GetMapping("user/week/best")
    @ApiOperation(value = "이번주 베스트 레시피", notes = "스크랩 부분 추가 수정 예정")
    public ResponseEntity<List<WeeklyBestRecipeResponseDto>> getWeeklyBestRecipe() {
        return ResponseEntity.ok(exhibitService.getWeeklyBestRecipe());
    }

    @GetMapping("user/popular/search/word")
    @ApiOperation(value = "인기 검색어", notes = "임시 데이터 출력")
    public ResponseEntity<List<PopularSearchWordResponseDto>> getPopularSearchWord() {
        return ResponseEntity.ok(exhibitService.getPopularSearchWord());
    }

    @GetMapping("user/recommend/recipe")
    @ApiOperation(value = "스크랩많은 레시피", notes = "임시 데이터 출력")
    public ResponseEntity<List<RecommendRecipeResponseDto>> getRecommendRecipe() {
        return ResponseEntity.ok(exhibitService.getRecommendRecipe());
    }

    @GetMapping("user/home/integrated")
    @ApiOperation(value = "홈 통합 데이터", notes = "홈 통합 데이터(임시 데이터 출력)")
    public ResponseEntity<HomeIntegratedResponseDto> getHomeIntegrated() {
        return ResponseEntity.ok(exhibitService.getHomeIntegrated());
    }
}
