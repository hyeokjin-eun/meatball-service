package com.service.ingredientservice.model.dto.ingredient.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "재료 즐겨찾기 등록/삭제 Request Model")
public class IngredientFavoritesUpdateRequestDto {

    @ApiModelProperty(value = "재료 식별자", required = true)
    private Long ingredientSeq;
}
