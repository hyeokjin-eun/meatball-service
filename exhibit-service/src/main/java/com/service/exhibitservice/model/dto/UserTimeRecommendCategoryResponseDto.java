package com.service.exhibitservice.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserTimeRecommendCategoryResponseDto {

    @ApiModelProperty(value = "사용자 이름", required = true, notes = "사용자 데이터 연동 작업 중")
    private String name;

    @ApiModelProperty(value = "추천 카테고리 리스트", required = true)
    private List<String> recommendCategoryList;
}
