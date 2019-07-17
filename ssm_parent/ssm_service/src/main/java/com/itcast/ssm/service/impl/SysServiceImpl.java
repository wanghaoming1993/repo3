package com.itcast.ssm.service.impl;

import com.itcast.ssm.dao.ISysDao;
import com.itcast.ssm.domain.SysLog;
import com.itcast.ssm.service.ISysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("sysService")
public class SysServiceImpl implements ISysService {
    @Autowired
    private ISysDao sysDao;

    @Override
    public void save(SysLog sysLog) {
        sysDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return sysDao.findAll();
    }
}
