package com.codals.greating.diet.service;

import com.codals.greating.diet.dao.DailyDietDao;
import com.codals.greating.diet.dto.PreviewDietResponseDto;
import com.codals.greating.diet.dto.PreviewResponseDto;
import com.codals.greating.diet.entity.DailyDiet;
import java.text.SimpleDateFormat;
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
        List<DailyDiet> dailyDiets = dailyDietDao.selectDailyDietsByStartDate(getDeliveryDateFormat(new Date()))
            .orElseGet(null);
        return getPreviewResponseDto(dailyDiets);
    }

    @Override
    public List<PreviewResponseDto> getDailyDietsByDeliveryDates(List<Date> deliveryDates) {
        List<String> deliveryDatesFormat = deliveryDates.stream().map(this::getDeliveryDateFormat)
            .collect(Collectors.toList());
        List<DailyDiet> dailyDiets = dailyDietDao.selectDailyDietsByStartDateOrEndDate(deliveryDatesFormat)
            .orElseGet(null);
        return getPreviewResponseDto(dailyDiets);
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

    private String getDeliveryDateFormat(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
