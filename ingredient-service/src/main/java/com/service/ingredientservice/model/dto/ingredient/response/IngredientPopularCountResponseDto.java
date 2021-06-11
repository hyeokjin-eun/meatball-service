package com.service.ingredientservice.model.dto.ingredient.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "인기 있는 재료 검색 Count 증가 Response Model")
public class IngredientPopularCountResponseDto {

    @ApiModelProperty(value = "인기 재료 Count 식별자", required = true)
    private Long seq;

    @ApiModelProperty(value = "재료 식별자", required = true)
    private Long ingredientSeq;

    @ApiModelProperty(value = "재료 검색 수", required = true)
    private Long count;
}
