package com.codals.greating.diet.dao;

import com.codals.greating.diet.dto.OrderDietRequestDto;
import com.codals.greating.diet.entity.OrderDiet;
import java.util.List;

public interface OrderDietDao {

    void insertOrderDiet(OrderDietRequestDto orderDiet);

    List<OrderDiet> selectAllByOrderId(Integer orderId);
}
