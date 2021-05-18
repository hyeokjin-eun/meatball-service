package com.service.exhibitservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RecipeEaseEnum {
    EASY("EASY", "쉬움"),
    MODERATE("MODERATE", "보통"),
    HARD("HARD", "어려움");

    private final String code;

    private final String description;
}
