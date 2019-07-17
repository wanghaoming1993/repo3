package com.itcast.ssm.test;

import com.itcast.ssm.dao.IPermissionDao;
import com.itcast.ssm.dao.IRoleDao;
import com.itcast.ssm.dao.IUserInfoDao;
import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.List;

public class RoleTest {

    @Autowired
    private IUserInfoDao userInfoDao;

    @Test
    public void testFindAll(){




    }
}
