package com.service.ingredientservice.model.dto.ingredient.assemble;

import com.service.ingredientservice.controller.IngredientController;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientPopularResponseDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IngredientPopularListAssemble implements RepresentationModelAssembler<IngredientPopularResponseDto, IngredientPopularResponseDto> {

    @Override
    public IngredientPopularResponseDto toModel(IngredientPopularResponseDto ingredientPopularResponseDto) {
        return ingredientPopularResponseDto;
    }

    public CollectionModel<IngredientPopularResponseDto> toCollectionModel(List<IngredientPopularResponseDto> ingredientPopularResponseDtoList) {
        return CollectionModel.of(ingredientPopularResponseDtoList.stream().map(this::toModel).collect(Collectors.toList()),
                linkTo(methodOn(IngredientController.class).popular()).withSelfRel());
    }
}
