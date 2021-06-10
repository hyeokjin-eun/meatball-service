package com.service.ingredientservice.controller;

import com.service.ingredientservice.model.dto.ingredient.request.IngredientListRequestDto;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientListResponseDto;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientUnitListResponseDto;
import com.service.ingredientservice.service.IngredientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
