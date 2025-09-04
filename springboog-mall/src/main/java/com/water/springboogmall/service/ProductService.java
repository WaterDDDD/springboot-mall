package com.water.springboogmall.service;

import com.water.springboogmall.dto.ProductRequest;
import com.water.springboogmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
