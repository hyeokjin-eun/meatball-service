package com.service.exhibitservice.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel("시간별 추천 레시피 Response Model")
public class UserTimeRecommendResponseDto {

    @ApiModelProperty(value = "사용자, 카테고리 데이터")
    private UserTimeRecommendCategoryResponseDto userTimeRecommendCategory;

    @ApiModelProperty(value = "시간별 추천 레시피 리스트")
    private List<UserTimeRecommendRecipeResponseDto> userTimeRecommendRecipeList;
}
