package com.service.exhibitservice.model.dto;

import com.service.exhibitservice.model.enums.RecipeEaseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "이번주 도전 레시피 Response Model")
public class WeeklyChallengeRecipeResponseDto {

    @ApiModelProperty(value = "레시피 식별자", required = true, notes = "현재 레피시 미연동")
    private Long recipeId;

    @ApiModelProperty(value = "제목", required = true)
    private String title;

    @ApiModelProperty(value = "이미지 URL", required = true, notes = "해당값 아직 미정으로 기본 이미지로 작업 요청")
    private String imgPath;

    @ApiModelProperty(value = "등록자", required = true)
    private String registerName;

    @ApiModelProperty(value = "난이도", required = true, allowableValues = "EASY, MODERATE, HARD")
    private RecipeEaseEnum ease;

    @ApiModelProperty(value = "조리 시간", required = true, notes = "ex) 10분")
    private String cookingTime;

    @ApiModelProperty(value = "스크랩 유무", required = true, notes = "Y : 스크랩된 상태, N : 스크랩안된 상태")
    private String isScrap;
}
