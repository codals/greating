package com.codals.greating.diet.dao;

import com.codals.greating.diet.dto.OrderRequestDto;

public interface OrderDao {

    void saveOrder(OrderRequestDto orderRequestDto);
}
