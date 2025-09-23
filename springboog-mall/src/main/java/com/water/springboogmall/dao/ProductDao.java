package com.water.springboogmall.dao;

import com.water.springboogmall.constant.ProductCategory;
import com.water.springboogmall.dto.ProductQueryParams;
import com.water.springboogmall.dto.ProductRequest;
import com.water.springboogmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void updateStock(Integer productId, Integer stock);

    void deleteProductById(Integer productId);
}
