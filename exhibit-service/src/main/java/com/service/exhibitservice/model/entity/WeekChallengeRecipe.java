package com.service.exhibitservice.model.entity;

import com.service.exhibitservice.model.enums.RecipeEaseEnum;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
@Entity
public class WeekChallengeRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long recipeId;

    private String title;

    private String imgPath;

    private String registerName;

    @Enumerated(EnumType.STRING)
    private RecipeEaseEnum ease;

    private String cookingTime;

    private LocalDateTime created;
}
