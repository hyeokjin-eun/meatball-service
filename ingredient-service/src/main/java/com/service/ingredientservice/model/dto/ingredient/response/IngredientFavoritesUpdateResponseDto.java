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
@ApiModel(value = "재료 즐겨찾기 등록/삭제 Response Model")
public class IngredientFavoritesUpdateResponseDto extends RepresentationModel<IngredientFavoritesUpdateResponseDto> {

    @ApiModelProperty(value = "재료 즐겨 찾기 식별자", required = true)
    private Long seq;

    @ApiModelProperty(value = "재료 식별자", required = true)
    private Long ingredientSeq;

    @ApiModelProperty(value = "사용자 식별자", required = true)
    private String userId;
}
