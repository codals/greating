package com.codals.greating.diet.entity;

import com.codals.greating.date.BaseEntity;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DailyDiet extends BaseEntity {

    private Integer id;
    private Integer dietId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Diet diet;
}
