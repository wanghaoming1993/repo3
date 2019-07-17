package com.itcast.ssm.service;

import com.itcast.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {



    List<Orders> findAllOrders(Integer pageNum,Integer pageSize) throws Exception;

    Orders findOrderByOrderId(String id);


}
