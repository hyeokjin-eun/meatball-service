package com.service.ingredientservice.service;

import com.service.ingredientservice.model.dto.ingredient.assemble.*;
import com.service.ingredientservice.model.dto.ingredient.request.IngredientFavoritesUpdateRequestDto;
import com.service.ingredientservice.model.dto.ingredient.request.IngredientListRequestDto;
import com.service.ingredientservice.model.dto.ingredient.request.ingredientPopularCountRequestDto;
import com.service.ingredientservice.model.dto.ingredient.response.*;
import com.service.ingredientservice.model.entity.Ingredient;
import com.service.ingredientservice.model.entity.IngredientFavorites;
import com.service.ingredientservice.model.entity.IngredientPopular;
import com.service.ingredientservice.repository.IngredientFavoritesRepository;
import com.service.ingredientservice.repository.IngredientPopularRepository;
import com.service.ingredientservice.repository.IngredientRepository;
import com.service.ingredientservice.repository.UnitRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    private final UnitRepository unitRepository;

    private final IngredientFavoritesRepository ingredientFavoritesRepository;

    private final IngredientPopularRepository ingredientPopularRepository;

    private final IngredientListAssemble ingredientListAssemble;

    private final IngredientUnitListAssemble ingredientUnitListAssemble;

    private final IngredientFavoritesListAssemble ingredientFavoritesListAssemble;

    private final IngredientFavoritesUpdateAssemble ingredientFavoritesUpdateAssemble;

    private final IngredientPopularListAssemble ingredientPopularListAssemble;

    public IngredientService(IngredientRepository ingredientRepository,
                             UnitRepository unitRepository,
                             IngredientFavoritesRepository ingredientFavoritesRepository,
                             IngredientPopularRepository ingredientPopularRepository,
                             IngredientListAssemble ingredientListAssemble,
                             IngredientUnitListAssemble ingredientUnitListAssemble,
                             IngredientFavoritesListAssemble ingredientFavoritesListAssemble,
                             IngredientFavoritesUpdateAssemble ingredientFavoritesUpdateAssemble,
                             IngredientPopularListAssemble ingredientPopularListAssemble) {
        this.ingredientRepository = ingredientRepository;
        this.unitRepository = unitRepository;
        this.ingredientFavoritesRepository = ingredientFavoritesRepository;
        this.ingredientPopularRepository = ingredientPopularRepository;
        this.ingredientListAssemble = ingredientListAssemble;
        this.ingredientUnitListAssemble = ingredientUnitListAssemble;
        this.ingredientFavoritesListAssemble = ingredientFavoritesListAssemble;
        this.ingredientFavoritesUpdateAssemble = ingredientFavoritesUpdateAssemble;
        this.ingredientPopularListAssemble = ingredientPopularListAssemble;
    }

    public CollectionModel<IngredientListResponseDto> ingredients(IngredientListRequestDto ingredientListRequestDto) {
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

    public CollectionModel<IngredientUnitListResponseDto> ingredientsUnits() {
        return ingredientUnitListAssemble.toCollectionModel(unitRepository.findAll().stream()
                .map(unit -> IngredientUnitListResponseDto.builder()
                        .seq(unit.getSeq())
                        .code(unit.getCode())
                        .name(unit.getName())
                        .build())
                .collect(Collectors.toList()));
    }

    public CollectionModel<IngredientFavoritesResponseDto> favoritesList() {
        //TODO 임시 데이터 출력
        return ingredientFavoritesListAssemble.toCollectionModel(ingredientFavoritesRepository.findByUserId("test01").stream()
                .map(ingredientFavorites -> {
                    Ingredient ingredient = ingredientRepository.findById(ingredientFavorites.getIngredientSeq())
                            .orElseThrow(RuntimeException::new);

                    return IngredientFavoritesResponseDto.builder()
                            .seq(ingredientFavorites.getSeq())
                            .name(ingredient.getName())
                            .isFavorites(true)
                            .build();
                })
                .collect(Collectors.toList()));
    }

    public IngredientFavoritesUpdateResponseDto favoritesUpdate(IngredientFavoritesUpdateRequestDto ingredientFavoritesUpdateRequestDto) {
        IngredientFavorites ingredientFavorites = ingredientFavoritesRepository.findByIngredientSeqAndUserId(ingredientFavoritesUpdateRequestDto.getIngredientSeq(), "test01")
                .orElse(null);

        if (ingredientFavorites != null) {
            ingredientFavoritesRepository.delete(ingredientFavorites);
        } else {
            ingredientFavorites = ingredientFavoritesRepository.save(IngredientFavorites.builder()
                    .ingredientSeq(ingredientFavoritesUpdateRequestDto.getIngredientSeq())
                    .userId("test01")
                    .build());
        }

        return ingredientFavoritesUpdateAssemble.toModel(IngredientFavoritesUpdateResponseDto.builder()
                .seq(ingredientFavorites.getSeq())
                .ingredientSeq(ingredientFavorites.getIngredientSeq())
                .userId(ingredientFavorites.getUserId())
                .build());
    }

    public CollectionModel<IngredientPopularResponseDto> popular() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("count").descending());
        return ingredientPopularListAssemble.toCollectionModel(ingredientPopularRepository.findAll(pageRequest).stream()
                .map(ingredientPopular -> {
                    Ingredient ingredient = ingredientRepository.findById(ingredientPopular.getIngredientSeq())
                            .orElseThrow(RuntimeException::new);

                    IngredientFavorites ingredientFavorites = ingredientFavoritesRepository.findByIngredientSeqAndUserId(ingredientPopular.getIngredientSeq(), "test01")
                            .orElse(null);

                    return IngredientPopularResponseDto.builder()
                            .seq(ingredientPopular.getSeq())
                            .name(ingredient.getName())
                            .isFavorites(ingredientFavorites != null)
                            .build();
                })
                .collect(Collectors.toList()));
    }

    public IngredientPopularCountResponseDto popularCount(ingredientPopularCountRequestDto ingredientPopularCountRequestDto) {
        IngredientPopular ingredientPopular = ingredientPopularRepository.findByIngredientSeq(ingredientPopularCountRequestDto.getIngredientSeq())
                .orElse(null);

        if (ingredientPopular != null) {
            ingredientPopular.setCount(ingredientPopular.getCount() + 1);
            ingredientPopular = ingredientPopularRepository.save(ingredientPopular);
        } else {
            ingredientPopular = ingredientPopularRepository.save(IngredientPopular.builder()
                    .ingredientSeq(ingredientPopularCountRequestDto.getIngredientSeq())
                    .count(0L)
                    .build());
        }

        return IngredientPopularCountResponseDto.builder()
                .seq(ingredientPopular.getSeq())
                .ingredientSeq(ingredientPopular.getIngredientSeq())
                .count(ingredientPopular.getCount())
                .build();
    }
}
