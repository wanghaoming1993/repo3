package com.itcast.ssm.service.impl;

import com.itcast.ssm.dao.IPermissionDao;
import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }
}
