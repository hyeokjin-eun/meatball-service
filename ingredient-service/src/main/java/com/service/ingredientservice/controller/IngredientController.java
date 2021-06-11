package com.service.ingredientservice.controller;

import com.service.ingredientservice.model.dto.ingredient.request.IngredientFavoritesUpdateRequestDto;
import com.service.ingredientservice.model.dto.ingredient.request.IngredientListRequestDto;
import com.service.ingredientservice.model.dto.ingredient.request.ingredientPopularCountRequestDto;
import com.service.ingredientservice.model.dto.ingredient.response.*;
import com.service.ingredientservice.service.IngredientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("ingredients")
    @ApiOperation(value = "재료 검색", notes = "재료 검색 API")
    public ResponseEntity<CollectionModel<IngredientListResponseDto>> ingredients(IngredientListRequestDto ingredientListRequestDto) {
        return ResponseEntity.ok(ingredientService.ingredients(ingredientListRequestDto));
    }

    @GetMapping("ingredients/units")
    @ApiOperation(value = "재료 단위 검색", notes = "재료 단위 검색 API")
    public ResponseEntity<CollectionModel<IngredientUnitListResponseDto>> ingredientsUnits() {
        return ResponseEntity.ok(ingredientService.ingredientsUnits());
    }

    @GetMapping("ingredients/units/favorites")
    @ApiOperation(value = "재료 즐겨 찾기 리스트", notes = "재료 즐겨 찾기 리스트 조회 API")
    public ResponseEntity<CollectionModel<IngredientFavoritesResponseDto>> favoritesList() {
        return ResponseEntity.ok(ingredientService.favoritesList());
    }

    @PutMapping("ingredients/units/favorites")
    @ApiOperation(value = "재료 즐겨 찾기 등록/삭제", notes = "재료 즐겨 찾기 등록/삭제 API")
    public ResponseEntity<IngredientFavoritesUpdateResponseDto> favoritesUpdate(@RequestBody IngredientFavoritesUpdateRequestDto ingredientFavoritesUpdateRequestDto) {
        return ResponseEntity.ok(ingredientService.favoritesUpdate(ingredientFavoritesUpdateRequestDto));
    }

    @GetMapping("ingredients/popular")
    @ApiOperation(value = "인기 있는 재료 조회", notes = "인기 있는 재료 조회 API")
    public ResponseEntity<CollectionModel<IngredientPopularResponseDto>> popular() {
        return ResponseEntity.ok(ingredientService.popular());
    }

    @PutMapping("ingredients/popular")
    @ApiOperation(value = "인기 있는 재료 검색 Count 증가", notes = "인기 있는 재료 검색 Count 증가")
    public ResponseEntity<IngredientPopularCountResponseDto> popularCount(@RequestBody ingredientPopularCountRequestDto ingredientPopularCountRequestDto) {
        return ResponseEntity.ok(ingredientService.popularCount(ingredientPopularCountRequestDto));
    }
}
