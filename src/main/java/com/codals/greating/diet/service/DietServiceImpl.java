package com.codals.greating.diet.service;

import com.codals.greating.diet.dao.DailyDietDao;
import com.codals.greating.diet.dto.PlanResponseDto;
import com.codals.greating.diet.dto.PreviewDietResponseDto;
import com.codals.greating.diet.dto.PreviewResponseDto;
import com.codals.greating.diet.entity.DailyDiet;
import com.codals.greating.user.entity.User;
import com.codals.greating.util.DateUtil;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService {

    private final DailyDietDao dailyDietDao;

    @Override
    public List<PreviewResponseDto> getWeeklyDailyDiets() {
        List<DailyDiet> dailyDiets = dailyDietDao.selectDailyDietsByStartDate(DateUtil.dateToString(new Date()))
            .orElseGet(null);
        return getPreviewResponseDto(dailyDiets);
    }

    @Override
    public List<PlanResponseDto> getDailyDietsByDeliveryDates(List<Date> deliveryDates) {
        return deliveryDates.stream()
            .map(deliveryDate -> {
                String deliveryDateFormat = DateUtil.dateToString(deliveryDate);
                List<DailyDiet> dailyDiets = dailyDietDao.selectAllByStartDateOrEndDate(deliveryDateFormat).orElse(null);
                List<PreviewDietResponseDto> dietsResponse = dailyDiets.stream()
                    .map(dailyDiet -> new PreviewDietResponseDto(dailyDiet.getDiet()))
                    .collect(Collectors.toList());
                return new PlanResponseDto(deliveryDateFormat, dietsResponse);
            })
            .collect(Collectors.toList());
    }

    private List<PreviewResponseDto> getPreviewResponseDto(List<DailyDiet> dailyDiets) {
        Map<LocalDate, List<DailyDiet>> dailyDietsByStartDate = dailyDiets.stream()
            .collect(Collectors.groupingBy(DailyDiet::getStartDate));

        return dailyDietsByStartDate.entrySet().stream()
            .map(entry -> new PreviewResponseDto(entry.getKey(), entry.getValue().stream()
                .map(this::getPreviewDietResponseDto)
                .collect(Collectors.toList())))
            .sorted(Comparator.comparing(PreviewResponseDto::getStartDate))
            .collect(Collectors.toList());
    }

    private PreviewDietResponseDto getPreviewDietResponseDto(DailyDiet dailyDiet) {
        return new PreviewDietResponseDto(dailyDiet.getDiet());
    }
}
