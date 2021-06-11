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
@ApiModel(value = "인기 있는 재료 검색 Count 증가 Request Model")
public class ingredientPopularCountRequestDto {

    @ApiModelProperty(value = "재료 식별자", required = true)
    private Long ingredientSeq;
}
