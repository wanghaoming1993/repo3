package com.itcast.ssm.dao;


import com.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public interface IProductDao {


    @Select("select * from product")
    List<Product> findAllProduct();


    @Select("select * from product where id=#{id}")
    Product findById(String id);

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
