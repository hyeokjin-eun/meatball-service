package com.service.exhibitservice.util;

import com.service.exhibitservice.model.enums.RecipeEaseEnum;

public class StringUtil {

    public static RecipeEaseEnum intConvertRecipeEaseEnum(int num) {
        RecipeEaseEnum recipeEaseEnum;
        switch (num) {
            case 1 :
                recipeEaseEnum = RecipeEaseEnum.EASY;
                break;
            case 2 :
                recipeEaseEnum = RecipeEaseEnum.MODERATE;
                break;
            default :
                recipeEaseEnum = RecipeEaseEnum.HARD;
        }

        return recipeEaseEnum;
    }
}
