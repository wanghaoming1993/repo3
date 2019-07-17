package com.itcast.ssm.dao;


import com.itcast.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sysDao")
public interface ISysDao {

    @Insert("insert into syslog(VISITTIME,USERNAME,IP,URL,EXECUTIONTIME,METHOD) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);


    @Select("select * from syslog")
    List<SysLog> findAll();
}
