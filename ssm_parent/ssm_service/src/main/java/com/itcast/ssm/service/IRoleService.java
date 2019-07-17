package com.itcast.ssm.service;

import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.domain.Role;

import java.util.List;

public interface IRoleService {


    List<Role> findAll();

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOthers(String roleId);

    void addPermission(String roleId, String[] ids);
}
