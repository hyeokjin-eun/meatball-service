package com.service.exhibitservice.service;

import com.service.exhibitservice.model.dto.*;
import com.service.exhibitservice.repository.WeekBestRecipeRepository;
import com.service.exhibitservice.repository.WeekChallengeRecipeRepository;
import com.service.exhibitservice.util.MathUtil;
import com.service.exhibitservice.util.StringUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExhibitService {

    private final WeekChallengeRecipeRepository weekChallengeRepository;

    private final WeekBestRecipeRepository weekBestRecipeRepository;

    public ExhibitService(
            WeekChallengeRecipeRepository weekChallengeRepository,
            WeekBestRecipeRepository weekBestRecipeRepository) {
        this.weekChallengeRepository = weekChallengeRepository;
        this.weekBestRecipeRepository = weekBestRecipeRepository;
    }

    /**
     * 시간별 레시피 추천 데이터
     * @return UserTimeRecommendResponseDto
     */
    public UserTimeRecommendResponseDto getUserTimeRecommendRecipe() {
        //TODO 사용자 데이터 처리 부분 신규 작성 필요
        String[] categoryTemp = {"#라면", "#불닭볶음면", "#볶음밥", "#치킨", "#떡볶이"};
        UserTimeRecommendCategoryResponseDto userTimeRecommendCategoryResponseDto = UserTimeRecommendCategoryResponseDto.builder()
                .name("전원우")
                .recommendCategoryList(Arrays.asList(categoryTemp))
                .build();

        //TODO 사용자 데이터 인지 확인 필요 (Swagger 문서 공유 위해 임시 데이터 작성)
        List<UserTimeRecommendRecipeResponseDto> userTimeRecommendRecipeResponseDtoList = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            int randomNum = MathUtil.randomNumber(3) + 1;
            userTimeRecommendRecipeResponseDtoList.add(UserTimeRecommendRecipeResponseDto.builder()
                    .recipeId((long) i)
                    .title("맛있는 레시피 " + i)
                    .imgPath(StringUtil.tempRandomImgPath())
                    .ease(StringUtil.intConvertRecipeEaseEnum(randomNum))
                    .cookingTime(i * 10 + "분")
                    .registerName("요리사" + i)
                    .isScrap(i % 2 == 0 ? "Y" : "N")
                    .build());
        }

        return UserTimeRecommendResponseDto.builder()
                .userTimeRecommendCategory(userTimeRecommendCategoryResponseDto)
                .userTimeRecommendRecipeList(userTimeRecommendRecipeResponseDtoList)
                .build();
    }

    /**
     * 매주 지정된 레시피 10개 (이번주 도전 요리)
     * @return List<WeeklyChallengeRecipeResponseDto>
     */
    public List<WeeklyChallengeRecipeResponseDto> getWeeklyChallengeRecipe() {
        //TODO 스크랩 부분 처리 필요
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("created").descending());
        return weekChallengeRepository.findAll(pageRequest).getContent().stream()
                    .map(weekChallengeRecipe -> WeeklyChallengeRecipeResponseDto.builder()
                            .recipeId(weekChallengeRecipe.getRecipeId())
                            .title(weekChallengeRecipe.getTitle())
                            .imgPath(weekChallengeRecipe.getImgPath())
                            .registerName(weekChallengeRecipe.getRegisterName())
                            .ease(weekChallengeRecipe.getEase())
                            .cookingTime(weekChallengeRecipe.getCookingTime() + "분")
                            .isScrap("N")
                            .build())
                    .collect(Collectors.toList());
    }

    /**
     * 주간 스크랩이 가장 많았던 레시피 10개 (이번주 베스트 레시피)
     * @return List<WeeklyBestRecipeResponseDto>
     */
    public List<WeeklyBestRecipeResponseDto> getWeeklyBestRecipe() {
        //TODO 스크랩 부분 처리 필요
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("created").descending());
        return weekBestRecipeRepository.findAll(pageRequest).getContent().stream()
                .map(weekBestRecipe -> WeeklyBestRecipeResponseDto.builder()
                        .recipeId(weekBestRecipe.getRecipeId())
                        .title(weekBestRecipe.getTitle())
                        .imgPath(weekBestRecipe.getImgPath())
                        .registerName(weekBestRecipe.getRegisterName())
                        .ease(weekBestRecipe.getEase())
                        .cookingTime(weekBestRecipe.getCookingTime() + "분")
                        .isScrap("N")
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * 인기 검색어 (1분동안 음식 검색에서 많이 검색된 음식 1~5위 노출)
     * @return List<PopularSearchWordResponseDto>
     */
    public List<PopularSearchWordResponseDto> getPopularSearchWord() {
        //TODO Redis 등을 이용해서 인기 검색어 만들지 확인 필요 (일단은 임시 데이터 작성)
        String[] searchWord = {"피자", "토스트", "부추전", "스테이크", "만두"};
        List<PopularSearchWordResponseDto> popularSearchWordList = new ArrayList<>();

        for (String word : searchWord) {
            int randomNum = MathUtil.randomNumber(3) + 1;
            List<SearchWordRelationRecipeResponseDto> searchWordRelationRecipeList = new ArrayList<>();
            int count = 1;
            for (int i = 0; i < randomNum; i++) {
                searchWordRelationRecipeList.add(SearchWordRelationRecipeResponseDto.builder()
                        .recipeId((long) count)
                        .imgPath(StringUtil.tempRandomImgPath())
                        .cookingTime(((randomNum + 1) * 10) + "분")
                        .ease(StringUtil.intConvertRecipeEaseEnum(randomNum))
                        .isScrap("N")
                        .build());

                count++;
            }


            popularSearchWordList.add(PopularSearchWordResponseDto.builder()
                    .searchWord(word)
                    .searchWordRelationRecipeList(searchWordRelationRecipeList)
                    .build());
        }

        return popularSearchWordList;
    }

    /**
     * 전체 레시피에서 스크랩 많은 순으로 10개 노출
     * @return List<RecommendRecipeResponseDto>
     */
    public List<RecommendRecipeResponseDto> getRecommendRecipe() {
        //TODO 스크랩 많은 순 적용 필요 (임시 데이터 작성)
        List<RecommendRecipeResponseDto> recommendRecipeResponseDtoList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            int randomNum = MathUtil.randomNumber(3);
            recommendRecipeResponseDtoList.add(RecommendRecipeResponseDto.builder()
                    .recipeId((long)i)
                    .title("맛있는 레시피" + i)
                    .imgPath(StringUtil.tempRandomImgPath())
                    .registerName("맛장인" + i)
                    .ease(StringUtil.intConvertRecipeEaseEnum(randomNum))
                    .cookingTime((i + 1) * 10 + "")
                    .isScrap(i % 2 == 0 ? "Y" : "N")
                    .build());
        }

        return recommendRecipeResponseDtoList;
    }

    /**
     * 홈 통합 데이터 조회
     * @return HomeIntegratedResponseDto
     */
    public HomeIntegratedResponseDto getHomeIntegrated() {
        return HomeIntegratedResponseDto.builder()
                .userTimeRecommendRecipe(getUserTimeRecommendRecipe())
                .weeklyChallengeRecipeList(getWeeklyChallengeRecipe())
                .weeklyBestRecipeList(getWeeklyBestRecipe())
                .popularSearchWordList(getPopularSearchWord())
                .recommendRecipeList(getRecommendRecipe())
                .build();
    }

    //TODO 검색 기록 바탕으로 레시피 노출
}