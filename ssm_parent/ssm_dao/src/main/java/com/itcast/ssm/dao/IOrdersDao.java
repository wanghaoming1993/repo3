package com.itcast.ssm.dao;


import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ordersDao")
public interface IOrdersDao {


    @Results(value = {
            @Result(id =true,property ="id",column ="id"),
            @Result(property ="orderNum",column ="orderNum"),
            @Result(property ="orderTime",column ="orderTime"),
            @Result(property ="peopleCount",column ="peopleCount"),
            @Result(property ="orderDesc",column ="orderDesc"),
            @Result(property ="payType",column ="payType"),
            @Result(property ="orderStatus",column ="orderStatus"),
            @Result(property ="product",column ="productid",
                    one=@One(select ="com.itcast.ssm.dao.IProductDao.findById"))
    })
    @Select("select * from orders")
    public List<Orders> findAllOrders();


    @Results(value = {
            @Result(id =true,property ="id",column ="id"),
            @Result(property ="orderNum",column ="orderNum"),
            @Result(property ="orderTime",column ="orderTime"),
            @Result(property ="peopleCount",column ="peopleCount"),
            @Result(property ="orderDesc",column ="orderDesc"),
            @Result(property ="payType",column ="payType"),
            @Result(property ="orderStatus",column ="orderStatus"),
            @Result(property ="product",column ="productid",
                    one=@One(select ="com.itcast.ssm.dao.IProductDao.findById")),
            @Result(property ="member",column ="memberid",
                    one=@One(select ="com.itcast.ssm.dao.IMemberDao.findByMemberId")),
            @Result(property ="list",column ="id",
                    one=@One(select ="com.itcast.ssm.dao.ITravellerDao.findTravellerByOrderId")),

    })
    @Select("select * from orders where id=#{id}")
    public Orders findOrderByOrderId(String id);

}
