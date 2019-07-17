package com.itcast.ssm.controller;


import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.domain.Role;
import com.itcast.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController extends FindAllController {
    @Autowired
    private IRoleService roleService;


    /**
     * 查询所有
     * @return
     */
    @RequestMapping("findAll")
    public ModelAndView findAll(){
        List<Role> roleList=roleService.findAll();
        return findAll(roleList,"list","role-list");
    }

    /**
     * 添加数据
     * @param role
     * @return
     */

    @RequestMapping("save")
    public ModelAndView save(Role role){

        roleService.save(role);

        ModelAndView mv=new ModelAndView();

        List<Role> roleList=roleService.findAll();

        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");

        return mv;
    }

    /**
     * 通过角色Id查询所有其他的权限
     * @param id
     * @return
     */
    @RequestMapping("findOthersById")
    public ModelAndView findOthersById(@RequestParam(value = "id",required =true)String id){
       Role role= roleService.findById(id);
       List<Permission> permissionList=roleService.findOthers(id);

       ModelAndView mv=new ModelAndView();
       mv.addObject("role",role);
       mv.addObject("permissionList",permissionList);

       mv.setViewName("role-permission-add");

       return mv;


    }

    /**
     * 给角色添加权限
     * @param roleId
     * @param ids
     * @return
     */
    @RequestMapping("addPermissionToRole")
    public String addPermissionToRole(@RequestParam(value = "roleId",required =true)String roleId,@RequestParam(value = "ids",required =true)String[] ids){

        roleService.addPermission(roleId,ids);

        return "redirect:findAll";
    }



}
