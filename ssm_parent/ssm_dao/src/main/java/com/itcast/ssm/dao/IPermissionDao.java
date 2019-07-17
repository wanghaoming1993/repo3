package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("permissionDao")
public interface IPermissionDao {



    /**
     * 通过RoleId找到permission
     * @param roleId
     * @return
     */

    @Select("select * from permission where id in(select permissionid from role_permission where roleid=#{roleId})")
    Permission findByRoleId(String roleId);


    @Results(id ="permissionMap",value ={
            @Result(id =true,property ="id",column ="id"),
            @Result(property ="permissionName",column ="permissionName"),
            @Result(property ="url",column ="url"),
            @Result(property ="roles",column ="id",many =
            @Many(select ="com.itcast.ssm.dao.IRoleDao.findByPermissionId"))
    })
    @Select("select * from permission")
    List<Permission> findAll();



    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);


}
