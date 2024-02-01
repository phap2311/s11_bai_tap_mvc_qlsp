package com.example.ss_11_quan_ly_san_pham.service;

import com.example.ss_11_quan_ly_san_pham.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Product product);


    void remove(Product product);


    List<Product> findByName(String nameProduct);
}
