package com.service.ingredientservice.model.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
@Entity
public class Ingredient {

    @Id
    private Long seq;

    private Long cateSeq;

    private String name;
}
