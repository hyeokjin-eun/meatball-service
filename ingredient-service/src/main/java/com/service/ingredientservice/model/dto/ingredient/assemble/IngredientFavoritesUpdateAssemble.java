package com.service.ingredientservice.model.dto.ingredient.assemble;

import com.service.ingredientservice.controller.IngredientController;
import com.service.ingredientservice.model.dto.ingredient.request.IngredientFavoritesUpdateRequestDto;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientFavoritesResponseDto;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientFavoritesUpdateResponseDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IngredientFavoritesUpdateAssemble implements RepresentationModelAssembler<IngredientFavoritesUpdateResponseDto, IngredientFavoritesUpdateResponseDto> {

    @Override
    public IngredientFavoritesUpdateResponseDto toModel(IngredientFavoritesUpdateResponseDto ingredientFavoritesUpdateResponseDto) {
        return ingredientFavoritesUpdateResponseDto;
    }

    public CollectionModel<IngredientFavoritesUpdateResponseDto> toCollectionModel(List<IngredientFavoritesUpdateResponseDto> ingredientFavoritesUpdateResponseDtoList) {
        return CollectionModel.of(ingredientFavoritesUpdateResponseDtoList.stream().map(this::toModel).collect(Collectors.toList()),
                linkTo(methodOn(IngredientController.class).favoritesUpdate(new IngredientFavoritesUpdateRequestDto())).withSelfRel());
    }
}
