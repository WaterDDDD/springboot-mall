package com.waterd.springbootmall.service.impl;

import com.waterd.springbootmall.dao.ProductDao;
import com.waterd.springbootmall.model.Product;
import com.waterd.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
