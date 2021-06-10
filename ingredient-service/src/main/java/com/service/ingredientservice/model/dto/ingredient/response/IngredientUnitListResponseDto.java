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
@ApiModel(value = "재료 단위 검색 Response Model")
public class IngredientUnitListResponseDto extends RepresentationModel<IngredientUnitListResponseDto> {

    @ApiModelProperty(value = "재료 단위 식별자", required = true)
    private Long seq;

    @ApiModelProperty(value = "재료 단위 코드", required = true)
    private String code;

    @ApiModelProperty(value = "재료 단위 명", required = true)
    private String name;
}
