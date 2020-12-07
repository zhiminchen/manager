package com.zhuoqu.slg.data.bi.stats.mybatis.dao;

import com.zhuoqu.slg.data.bi.stats.mybatis.entity.ServerHttp;
import java.util.List;

public interface ServerHttpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServerHttp record);

    ServerHttp selectByPrimaryKey(Integer id);

    List<ServerHttp> selectAll();

    int updateByPrimaryKey(ServerHttp record);
}