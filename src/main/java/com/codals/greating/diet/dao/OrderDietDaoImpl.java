package com.codals.greating.diet.dao;

import com.codals.greating.diet.dto.OrderDietRequestDto;
import com.codals.greating.diet.entity.OrderDiet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class OrderDietDaoImpl implements OrderDietDao {

    private final SqlSession sqlSession;

    @Override
    public void insertOrderDiet(OrderDietRequestDto orderDiet) {
        try {
            sqlSession.insert("orderDiet.insertOrderDiet", orderDiet);
        } catch (Exception e) {
            log.warn("Invalid diet item");
            throw new IllegalArgumentException("InsertOrderDietException: {}", e);
        }
    }

    @Override
    public List<OrderDiet> selectAllByOrderId(Integer orderId) {
        return sqlSession.selectList("orderDiet.selectAllByOrderId", orderId);
    }
}
