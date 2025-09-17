package com.water.springboogmall.service.Impl;


import com.water.springboogmall.dao.OrderDao;
import com.water.springboogmall.dao.ProductDao;
import com.water.springboogmall.dto.BuyItem;
import com.water.springboogmall.dto.CreateOrderRequest;
import com.water.springboogmall.model.OrderItem;
import com.water.springboogmall.model.Product;
import com.water.springboogmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;


    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            //計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);

        }


        //創建訂單
        Integer orderID = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderID, orderItemList);

        return orderID;
    }
}
