package com.water.springboogmall.service;

import com.water.springboogmall.dto.CreateOrderRequest;
import com.water.springboogmall.dto.OrderQueryParams;
import com.water.springboogmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
