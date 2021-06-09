package com.service.ingredientservice.model.dto.ingredient.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "재료 검색 Request Model")
public class IngredientListRequestDto {

    @ApiModelProperty(value = "검색 키워드", required = true)
    private String searchWord;
}
