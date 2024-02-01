package com.example.ss_11_quan_ly_san_pham.service;

import com.example.ss_11_quan_ly_san_pham.models.Product;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private List<Product> products = new ArrayList<>();

    {
        products.add(new Product(1, "tivi", 15, "siêu mỏng", "panasonic"));
        products.add(new Product(2, "tủ lạnh", 11, "bền", "sam sum"));
        products.add(new Product(3, "máy giặt", 8, "siêu nhanh", "panasonic"));
        products.add(new Product(4, "điện thoại", 22, "nhẹ, đẹp", "apple"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(Integer id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (Product product1 : products){
            if(product1.getId() == product.getId()){
                product1.setNameProduct(product.getNameProduct());
                product1.setPriceProduct(product.getPriceProduct());
                product1.setDescription(product.getDescription());
                product1.setCompany(product.getCompany());
                break;
            }
        }
    }

    @Override
    public void remove(Product product) {
        products.remove(product);
    }

    @Override
    public List<Product> findByName(String nameProduct) {
        List<Product>products1 = new ArrayList<>();
        for (Product product : products){
            if(product.getNameProduct().equals(nameProduct)){
                products1.add(product);
            }
        }
        return products1;
    }


}
