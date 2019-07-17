package com.itcast.ssm.service;


import com.itcast.ssm.domain.SysLog;

import java.util.List;


public interface ISysService {

    void save(SysLog sysLog);

    List<SysLog> findAll();
}
