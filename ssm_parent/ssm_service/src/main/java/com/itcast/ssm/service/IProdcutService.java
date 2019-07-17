package com.itcast.ssm.service;

import com.itcast.ssm.domain.Product;

import java.util.List;

public interface IProdcutService {


    List<Product> findAllProduct(Integer page,Integer pageSize) throws Exception;

    public void save(Product product);
}
