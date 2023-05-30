package com.codals.greating.diet.service;

import com.codals.greating.diet.dao.DailyDietDao;
import com.codals.greating.diet.dao.DietDao;
import com.codals.greating.diet.dto.PreviewDietResponseDto;
import com.codals.greating.diet.dto.PreviewResponseDto;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.diet.entity.Diet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService {

    private final DailyDietDao dailyDietDao;
    private final DietDao dietDao;

    @Override
    public List<PreviewResponseDto> getWeeklyDailyDiets() {
        List<DailyDiet> dailyDiets = dailyDietDao.selectDailyDietsByStartDate(getCurrentDateFormat()).orElseGet(null);
        Map<LocalDate, List<DailyDiet>> dailyDietsByStartDate = dailyDiets.stream()
            .collect(Collectors.groupingBy(DailyDiet::getStartDate));

        return dailyDietsByStartDate.entrySet().stream()
            .map(entry -> {
                LocalDate startDate = entry.getKey();
                List<DailyDiet> dailyDietList = entry.getValue();
                List<PreviewDietResponseDto> diets = dailyDietList.stream()
                    .map(dailyDiet -> new PreviewDietResponseDto(getDietByDailyDiet(dailyDiet)))
                    .collect(Collectors.toList());
                return new PreviewResponseDto(startDate, diets);
            })
            .sorted(Comparator.comparing(PreviewResponseDto::getStartDate))
            .collect(Collectors.toList());
    }

    private String getCurrentDateFormat() {
        LocalDate today = LocalDate.now();
        return today.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
    }

    private Diet getDietByDailyDiet(DailyDiet dailyDiet) {
        return dietDao.findById(dailyDiet.getDietId()).orElseGet(Diet::new);
    }
}
