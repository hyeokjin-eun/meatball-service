package com.service.ingredientservice.model.dto.ingredient.assemble;

import com.service.ingredientservice.controller.IngredientController;
import com.service.ingredientservice.model.dto.ingredient.request.IngredientListRequestDto;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientFavoritesResponseDto;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientListResponseDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IngredientFavoritesListAssemble implements RepresentationModelAssembler<IngredientFavoritesResponseDto, IngredientFavoritesResponseDto> {

    @Override
    public IngredientFavoritesResponseDto toModel(IngredientFavoritesResponseDto ingredientFavoritesResponseDto) {
        return ingredientFavoritesResponseDto;
    }

    public CollectionModel<IngredientFavoritesResponseDto> toCollectionModel(List<IngredientFavoritesResponseDto> ingredientFavoritesResponseDtoList) {
        return CollectionModel.of(ingredientFavoritesResponseDtoList.stream().map(this::toModel).collect(Collectors.toList()),
                linkTo(methodOn(IngredientController.class).favoritesList()).withSelfRel());
    }
}
