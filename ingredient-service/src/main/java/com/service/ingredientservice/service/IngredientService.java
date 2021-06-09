package com.service.ingredientservice.service;

import com.service.ingredientservice.model.dto.ingredient.assemble.IngredientListAssemble;
import com.service.ingredientservice.model.dto.ingredient.request.IngredientListRequestDto;
import com.service.ingredientservice.model.dto.ingredient.response.IngredientListResponseDto;
import com.service.ingredientservice.repository.IngredientRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    private final IngredientListAssemble ingredientListAssemble;

    public IngredientService(IngredientRepository ingredientRepository, IngredientListAssemble ingredientListAssemble) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientListAssemble = ingredientListAssemble;
    }

    public CollectionModel<IngredientListResponseDto> Ingredients(IngredientListRequestDto ingredientListRequestDto) {
        List<IngredientListResponseDto> listRequestDtoList;
        if (ingredientListRequestDto != null && ingredientListRequestDto.getSearchWord() != null) {
            listRequestDtoList = ingredientRepository.findByNameContains(ingredientListRequestDto.getSearchWord()).stream()
                    .map(ingredient -> IngredientListResponseDto.builder()
                            .seq(ingredient.getSeq())
                            .name(ingredient.getName())
                            .build())
                    .collect(Collectors.toList());
        } else {
            listRequestDtoList = ingredientRepository.findAll().stream()
                    .map(ingredient -> IngredientListResponseDto.builder()
                            .seq(ingredient.getSeq())
                            .name(ingredient.getName())
                            .build())
                    .collect(Collectors.toList());
        }

        if (listRequestDtoList.size() < 1 && ingredientListRequestDto != null && !ingredientListRequestDto.getSearchWord().equals("")) {
            listRequestDtoList = ingredientRepository.findByNameContains("기타").stream()
                    .map(ingredient -> IngredientListResponseDto.builder()
                            .seq(ingredient.getSeq())
                            .name(ingredient.getName())
                            .build())
                    .collect(Collectors.toList());
        }

        return ingredientListAssemble.toCollectionModel(listRequestDtoList);
    }
}
