package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("travellerDao")
public interface ITravellerDao {

    @Select("select * from traveller where id " +
            "in(select travellerid from order_traveller where orderid=#{orderid})")
    List<Traveller> findTravellerByOrderId(String orderid);

}
