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
@ApiModel(value = "재료 검색 Response Model")
public class IngredientListResponseDto extends RepresentationModel<IngredientListResponseDto> {

    @ApiModelProperty(value = "재료 식별자", required = true)
    private Long seq;

    @ApiModelProperty(value = "재료 명", required = true)
    private String name;
}
