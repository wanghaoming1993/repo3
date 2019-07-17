package com.itcast.ssm.dao;


import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userInfoDao")
public interface IUserInfoDao {






    @Results(id ="userInfoMap",value = {
            @Result(id =true,property ="id",column ="id"),
            @Result(property ="username",column ="username"),
            @Result(property ="email",column ="email"),
            @Result(property ="password",column ="password"),
            @Result(property ="phoneNum",column ="phoneNum"),
            @Result(property ="status",column ="status"),
            @Result(property ="roles",column ="id",many =@Many(
                    select ="com.itcast.ssm.dao.IRoleDao.findByUserId"
                    ))
    })
    @Select("select * from users where username=#{username}")
    public UserInfo findUserInfoByUsername(String username);


    @ResultMap("userInfoMap")
    @Select("select * from users")
    List<UserInfo> findAll();
    @Insert("insert into users(username,email,password,phoneNum,status) values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);


    @ResultMap("userInfoMap")
    @Select("select * from users where id=#{id}")
    UserInfo findById(String id);



    @Select("select * from users where id in(select userid from users_role where roleid=#{roleId})")
    UserInfo findByRoleId(String roleId);

   @Select("select * from role where id not in(select roleid from users_role where userid=#{id})")
    List<Role> findOtherUserById(String id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void saveRoles(@Param("userId") String userId, @Param("roleId") String roleId);
}
