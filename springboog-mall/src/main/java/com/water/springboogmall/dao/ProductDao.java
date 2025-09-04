package com.water.springboogmall.dao;

import com.water.springboogmall.dto.ProductRequest;
import com.water.springboogmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
