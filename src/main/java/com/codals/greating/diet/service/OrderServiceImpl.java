package com.codals.greating.diet.service;

import com.codals.greating.diet.dao.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Override
    public int getCompletedOrderCnt(Integer userId) {
        return orderDao.selectCountOfCompletedOrdersByUserId(userId);
    }
}
