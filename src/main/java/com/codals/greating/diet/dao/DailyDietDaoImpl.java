package com.codals.greating.diet.dao;

import com.codals.greating.diet.entity.DailyDiet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DailyDietDaoImpl implements DailyDietDao {

    private final SqlSession sqlSession;

    @Override
    public List<DailyDiet> selectAllByStartDate(String startDateFormat) {
        return sqlSession.selectList("dailyDiet.selectAllByStartDate", startDateFormat);
    }

    @Override
    public List<DailyDiet> selectAllByStartDateOrEndDate(String deliveryDateFormat) {
        return sqlSession.selectList("dailyDiet.selectAllByStartDateOrEndDate", deliveryDateFormat);
    }
}
