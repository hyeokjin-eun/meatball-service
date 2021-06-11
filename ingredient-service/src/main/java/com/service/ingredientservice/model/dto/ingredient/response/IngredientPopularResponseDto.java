package com.service.ingredientservice.model.dto.ingredient.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "인기 있는 재료 조회 Response Model")
public class IngredientPopularResponseDto extends RepresentationModel<IngredientPopularResponseDto> {

    @ApiModelProperty(value = "재료 식별자", required = true)
    private Long seq;

    @ApiModelProperty(value = "재료 명", required = true)
    private String name;

    @ApiModelProperty(value = "재료 즐겨찾기 여부", required = true)
    private boolean isFavorites;
}
