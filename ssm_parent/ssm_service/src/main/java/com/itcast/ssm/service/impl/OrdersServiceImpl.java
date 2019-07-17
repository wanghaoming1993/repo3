package com.itcast.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.itcast.ssm.dao.IOrdersDao;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;


    @Override
    public List<Orders> findAllOrders(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAllOrders();
    }

    @Override
    public Orders findOrderByOrderId(String id) {
        return ordersDao.findOrderByOrderId(id);
    }
}
