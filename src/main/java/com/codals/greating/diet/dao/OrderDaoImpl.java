package com.codals.greating.diet.dao;

import com.codals.greating.diet.dto.OrderRequestDto;
import com.codals.greating.diet.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {

    private final SqlSession sqlSession;

    @Override
    public void saveOrder(OrderRequestDto orderRequestDto) {
        try {
            sqlSession.insert("order.saveOrder", orderRequestDto);
        } catch (Exception e) {
            log.warn("Failed to save order.");
            throw new IllegalArgumentException("SaveOrderException: {}", e);
        }
    }

    @Override
    public Order selectById(Integer orderId) {
        return sqlSession.selectOne("order.selectById", orderId);
    }

    @Override
    public int selectCountOfCompletedOrdersByUserId(Integer userId) {
        return sqlSession.selectOne("order.selectCountOfCompletedOrdersByUserId", userId);
    }
}
