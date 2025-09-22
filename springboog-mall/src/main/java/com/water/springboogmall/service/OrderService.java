package com.water.springboogmall.service;

import com.water.springboogmall.dto.CreateOrderRequest;
import com.water.springboogmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
