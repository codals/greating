package com.codals.greating.diet.dao;

import com.codals.greating.diet.dto.OrderRequestDto;
import com.codals.greating.diet.entity.Order;

public interface OrderDao {

    void saveOrder(OrderRequestDto orderRequestDto);

    Order selectById(Integer orderId);
}
