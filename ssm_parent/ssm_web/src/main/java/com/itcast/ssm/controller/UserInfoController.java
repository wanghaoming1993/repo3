package com.itcast.ssm.controller;


import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import com.itcast.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserInfoController {
    @Autowired
    private IUserService userService;

    /**
     * 查询所有
     * @return
     */

    @PreAuthorize("authentication.principal.username=='zhangsan'")
    @RequestMapping("findAll")
    public ModelAndView findAll(){

      List<UserInfo> userInfoList=userService.findAll();
      ModelAndView mv=new ModelAndView();
      mv.addObject("userList",userInfoList);
      mv.setViewName("user-list");
      return mv;
    }

    /**
     * 添加数据
     * @param userInfo
     * @return
     */

    @RequestMapping("save")
    public ModelAndView save(UserInfo userInfo){
        userService.save(userInfo);

        List<UserInfo> userInfoList=userService.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("userList",userInfoList);
        mv.setViewName("user-list");
        return mv;

    }

    /**
     * 查询详情
     * @param id
     * @return
     */

    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam(value ="id",required =true) String id){

        UserInfo userInfo=userService.findById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 通过所有当前用户所对应的Id查出所有的其他角色
     * @param id
     * @return
     */
    @RequestMapping("findOthersById")
    public ModelAndView findOthersById(@RequestParam(value = "id",required =true)String id){

        UserInfo userInfo=userService.findById(id);
        List<Role> roleList = userService.findOtherUserById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     *给用户添加角色
     * @param userId
     * @param ids
     * @return
     */

    @RequestMapping("addRoleToUser")
    public String addRoleToUser(@RequestParam(value = "userId",required =true)String userId, @RequestParam(value = "ids",required =true)String[] ids){
        userService.addRoles(userId,ids);
        return "redirect:findAll";
    }


}
