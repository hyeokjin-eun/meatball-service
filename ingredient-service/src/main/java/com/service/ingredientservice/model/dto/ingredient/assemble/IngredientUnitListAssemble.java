package com.service.ingredientservice.model.dto.ingredient.assemble;

import com.service.ingredientservice.controller.IngredientController;
import com.service.ingredientservice.model.dto.ingredient.request.IngredientListRequestDto;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientListResponseDto;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientUnitListResponseDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IngredientUnitListAssemble implements RepresentationModelAssembler<IngredientUnitListResponseDto, IngredientUnitListResponseDto> {

    @Override
    public IngredientUnitListResponseDto toModel(IngredientUnitListResponseDto ingredientUnitListResponseDto) {
        return ingredientUnitListResponseDto;
    }

    public CollectionModel<IngredientUnitListResponseDto> toCollectionModel(List<IngredientUnitListResponseDto> ingredientUnitListResponseDtoList) {
        return CollectionModel.of(ingredientUnitListResponseDtoList.stream().map(this::toModel).collect(Collectors.toList()),
                linkTo(methodOn(IngredientController.class).ingredients(new IngredientListRequestDto())).withSelfRel());
    }
}
