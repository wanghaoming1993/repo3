package com.itcast.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.itcast.ssm.domain.Product;
import com.itcast.ssm.service.IProdcutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller()
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProdcutService prodcutService;

    /*@RequestMapping("findAll")
    public ModelAndView findAll(){
        List<Product> prodcuctList = prodcutService.findAllProduct();

        ModelAndView mv=new ModelAndView();

        mv.addObject("productlist",prodcuctList);

        mv.setViewName("product-list");
        return mv;
    }*/

    /**
     * 分页查询
     * @param
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("findAll")
    public ModelAndView findAll(
        @RequestParam(value ="page",required =true,defaultValue ="1") Integer page,
        @RequestParam(value = "pageSize",required =true,defaultValue ="3") Integer pageSize) throws Exception {
        List<Product> prodcuctList = prodcutService.findAllProduct(page, pageSize);
        ModelAndView mv=new ModelAndView();
        PageInfo pi=new PageInfo(prodcuctList);
        mv.addObject("pi",pi);
        mv.setViewName("product-list");
       return mv;
    }
    /**
     * 存product数据
     * @param product
     * @return
     */

    @RequestMapping("save")
    public ModelAndView saveProduct(Product product,
        @RequestParam(value ="page",required =true,defaultValue ="1") Integer page,
        @RequestParam(value = "pageSize",required =true,defaultValue ="3") Integer pageSize                         ) throws Exception {
        prodcutService.save(product);

        ModelAndView mv=new ModelAndView();

        List<Product> productList = prodcutService.findAllProduct(page, pageSize);

        PageInfo pi=new PageInfo(productList);
        mv.addObject("pi",pi);
        mv.setViewName("product-list");
        return mv;
    }


}
