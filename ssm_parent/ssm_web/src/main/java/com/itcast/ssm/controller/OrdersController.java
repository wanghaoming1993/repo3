package com.itcast.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController  extends FindAllController{

    @Autowired
    private IOrdersService  ordersService;

    /**
     * 查询所有订单未分页
     * @return
     */

    /*@RequestMapping("findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();

        List<Orders> ordersList = ordersService.findAllOrders();

        mv.addObject("ordersList",ordersList);

        mv.setViewName("orders-list");

        return mv;

    }*/

    /**
     * 分页查询所有的订单
     * @param
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */

    @RequestMapping("findAllPages")
    public ModelAndView findAllPages(
       @RequestParam(value="page",required =true,defaultValue ="1") Integer page,
       @RequestParam(value ="pageSize",required =true,defaultValue ="3") Integer pageSize) throws Exception {
        List<Orders> ordersList = ordersService.findAllOrders(page, pageSize);
        PageInfo pi=new PageInfo(ordersList);
        return find(pi,"pi","orders-list");
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam(value ="id",required =true)String id){
        Orders order = ordersService.findOrderByOrderId(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }

}
