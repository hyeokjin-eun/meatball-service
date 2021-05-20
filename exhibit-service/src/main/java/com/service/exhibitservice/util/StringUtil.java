package com.service.exhibitservice.util;

import com.service.exhibitservice.model.enums.RecipeEaseEnum;

import java.util.Random;

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

    public static String tempRandomImgPath() {
        int randomNum = new Random().nextInt(10) + 1;
        String imgName = "temp" + randomNum + ".jpeg";
        return "http://ctk0327.iptime.org:25000/exhibitservice/static/" + imgName;

    }
}
