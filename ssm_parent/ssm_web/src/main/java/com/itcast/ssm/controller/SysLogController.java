package com.itcast.ssm.controller;


import com.itcast.ssm.domain.SysLog;
import com.itcast.ssm.service.ISysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysLog")
public class SysLogController extends FindAllController {
    @Autowired
    private ISysService sysService;


    @RequestMapping("findAll")
    public ModelAndView findAll(){
        List<SysLog> sysLogList=sysService.findAll();
        return findAll(sysLogList,"sysLogList","syslog-list");
    }


}
