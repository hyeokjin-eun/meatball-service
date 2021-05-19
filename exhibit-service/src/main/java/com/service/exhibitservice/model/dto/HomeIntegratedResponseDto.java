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
@ApiModel(value = "홈 통합 데이터 Response Model")
public class HomeIntegratedResponseDto {

    @ApiModelProperty(value = "시간별 추천 레시피", required = true)
    private UserTimeRecommendResponseDto userTimeRecommendRecipe;

    @ApiModelProperty(value = "이번주 도전 레시", required = true)
    private List<WeeklyChallengeRecipeResponseDto> weeklyChallengeRecipeList;

    @ApiModelProperty(value = "이번주 베스트 레시피", required = true)
    private List<WeeklyBestRecipeResponseDto> weeklyBestRecipeList;

    @ApiModelProperty(value = "인기 검색어", required = true)
    private List<PopularSearchWordResponseDto> popularSearchWordList;

    @ApiModelProperty(value = "추천 레시피", required = true)
    private List<RecommendRecipeResponseDto> recommendRecipeList;
}
