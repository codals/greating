package com.codals.greating.diet.dao;

import com.codals.greating.diet.entity.DailyDiet;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DailyDietDaoImpl implements DailyDietDao {

    private final SqlSession sqlSession;

    @Override
    public Optional<List<DailyDiet>> selectDailyDietsByStartDate(String startDateFormat) {
        return Optional.ofNullable(sqlSession.selectList("dailyDiet.selectAllByStartDate", startDateFormat));
    }
}
