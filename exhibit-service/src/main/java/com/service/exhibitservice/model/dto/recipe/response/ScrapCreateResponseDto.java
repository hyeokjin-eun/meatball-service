package com.service.exhibitservice.model.dto.recipe.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "레시피 스크랩 생성 Response Model")
public class ScrapCreateResponseDto {

    @ApiModelProperty(value = "스크랩 식별자", required = true)
    private Long scrapId;

    @ApiModelProperty(value = "레피시 식별자", required = true)
    private Long recipeId;

    @ApiModelProperty(value = "사용자 식별자", required = true)
    private Long userId;
}
