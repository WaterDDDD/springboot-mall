package com.water.springboogmall.service;

import com.water.springboogmall.constant.ProductCategory;
import com.water.springboogmall.dto.ProductRequest;
import com.water.springboogmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
