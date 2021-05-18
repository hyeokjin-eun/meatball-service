package com.service.exhibitservice.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "인기 검색어 Response Model")
public class PopularSearchWordResponseDto {

    @ApiModelProperty(value = "검색어", required = true)
    private String searchWord;

    @ApiModelProperty(value = "검색어 연관 레시피", required = true)
    private List<SearchWordRelationRecipeResponseDto> searchWordRelationRecipeList;
}
