package com.itcast.ssm.service;

import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    UserInfo findById(String id);

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    List<Role> findOtherUserById(String id);

    void addRoles(String userId, String[] ids);
}
