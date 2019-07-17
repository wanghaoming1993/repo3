package com.itcast.ssm.controller;


import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("findAll")
    public ModelAndView findAll(){

        ModelAndView mv=new ModelAndView();

        List<Permission> permissionList=permissionService.findAll();

        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list1");

        return mv;
    }

    /**
     * 添加数据
     * @param permission
     * @return
     */

    @RequestMapping("save")
    public ModelAndView save(Permission permission){

        permissionService.save(permission);

        ModelAndView mv=new ModelAndView();

        List<Permission> permissionList=permissionService.findAll();

        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");

        return mv;

    }

    @RequestMapping("findddd")
    public @ResponseBody List<Permission> findddd(){



        List<Permission> permissionList=permissionService.findAll();




        return permissionList;
    }

}
