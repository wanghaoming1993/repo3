package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public interface IMemberDao {

    @Select("select * from member where id =#{id}")
    Member findByMemberId(String id);

}
