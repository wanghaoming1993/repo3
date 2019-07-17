package com.itcast.ssm.service.impl;

import com.itcast.ssm.dao.IUserInfoDao;
import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import com.itcast.ssm.service.IUserService;
import com.itcast.ssm.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserInfoDao userInfoDao;


    /**
     * 传入SpringSecurity所需要的User对象
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo  userInfo= userInfoDao.findUserInfoByUsername(username);
        List<Role> roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> authoritys = getAuthority(roles);
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),
                userInfo.getStatus()==0?false:true,true,true,true,authoritys);

        return user;

    }

    /**
     * 获取权限
     * @param roles
     * @return
     */
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    /**
     * 查询详情
     * @param id
     * @return
     */

    @Override
    public UserInfo findById(String id) {
       return userInfoDao.findById(id);
    }

    /**
     * 查询所有的userInfo
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }


    /**
     * 存userInfo
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {
        //对密码进行加密
        userInfo.setPassword(PasswordEncoder.getPassword(userInfo.getPassword()));
        userInfoDao.save(userInfo);
    }

    @Override
    public List<Role> findOtherUserById(String id) {
        return userInfoDao.findOtherUserById(id);
    }

    @Override
    public void addRoles(String userId, String[] ids) {
        for (String id : ids) {
            userInfoDao.saveRoles(userId,id);
        }
    }
}
