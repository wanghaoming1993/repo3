package com.itcast.ssm.service;

import com.itcast.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {



    void save(Permission permission);

    List<Permission> findAll();
}
