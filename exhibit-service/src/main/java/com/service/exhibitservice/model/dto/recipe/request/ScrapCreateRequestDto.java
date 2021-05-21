package com.service.exhibitservice.model.dto.recipe.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "레시피 스크랩 생성 Request Model")
public class ScrapCreateRequestDto {

    @ApiModelProperty(value = "스크랩 식별자", required = true)
    private Long scrapId;

    @ApiModelProperty(value = "레시피 식별자", required = true)
    private Long recipeId;

    @ApiModelProperty(value = "사용자 식별자", required = true)
    private Long userId;
}
