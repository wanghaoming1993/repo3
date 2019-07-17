package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("roleDao")
public interface IRoleDao {



    @Results(id ="roleMap",value ={
            @Result(id =true,property ="id",column ="id"),
            @Result(property ="roleName",column ="roleName"),
            @Result(property ="roleDesc",column ="roleDesc"),
            @Result(property ="permissions",column ="id",many =
            @Many(select ="com.itcast.ssm.dao.IPermissionDao.findByRoleId")
            ),
            @Result(property ="users",column ="id",many =
            @Many(select ="com.itcast.ssm.dao.IUserInfoDao.findByRoleId")
            )
    })
    @Select("select * from role where id in(select roleid from users_role where userid=#{userId} )")
    Role findByUserId(String userId);

    @ResultMap("roleMap")
    @Select("select * from role")
    List<Role> findAll();


    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id in(select roleId from role_permission where permissionid=#{permissionId})")
    Role findByPermissionId(String permissionId);

    @ResultMap("roleMap")
    @Select("select * from role where id=#{id}")
    Role findById(String id);


    @Select("Select * from permission where id not in(select permissionid from role_permission where roleid=#{id} )")
    List<Permission> findOthersById(String id);

    @Insert("insert into role_permission(permissionid,roleId) values(#{permissionid},#{roleId})")
    void addPermissionToRole(@Param("roleId")String roleId,@Param("permissionid")String permissionid);
}
