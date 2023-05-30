package com.codals.greating.diet.entity;

import com.codals.greating.date.BaseEntity;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyDiet extends BaseEntity {

    private Integer id;
    private Integer dietId;
    private LocalDate startDate;
    private LocalDate endDate;
}
