package com.zhuoqu.slg.data.bi.stats.mybatis.dao;

import com.zhuoqu.slg.data.bi.stats.mybatis.entity.LoginType;
import java.util.List;

public interface LoginTypeMapper {
    int deleteByPrimaryKey(Integer type);

    int insert(LoginType record);

    LoginType selectByPrimaryKey(Integer type);

    List<LoginType> selectAll();

    int updateByPrimaryKey(LoginType record);
}