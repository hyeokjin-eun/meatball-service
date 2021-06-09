package com.service.ingredientservice.model.dto.ingredient.assemble;

import com.service.ingredientservice.controller.IngredientController;
import com.service.ingredientservice.model.dto.ingredient.request.IngredientListRequestDto;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientListResponseDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IngredientListAssemble implements RepresentationModelAssembler<IngredientListResponseDto, IngredientListResponseDto> {

    @Override
    public IngredientListResponseDto toModel(IngredientListResponseDto ingredientListResponseDto) {
        return ingredientListResponseDto;
    }

    public CollectionModel<IngredientListResponseDto> toCollectionModel(List<IngredientListResponseDto> ingredientListResponseDtoList) {
        return CollectionModel.of(ingredientListResponseDtoList.stream().map(this::toModel).collect(Collectors.toList()),
                linkTo(methodOn(IngredientController.class).Ingredients(new IngredientListRequestDto())).withSelfRel());
    }
}
