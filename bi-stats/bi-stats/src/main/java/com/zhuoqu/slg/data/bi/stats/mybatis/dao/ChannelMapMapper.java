package com.zhuoqu.slg.data.bi.stats.mybatis.dao;

import com.zhuoqu.slg.data.bi.stats.mybatis.entity.ChannelMap;
import java.util.List;

public interface ChannelMapMapper {
    int deleteByPrimaryKey(String channleName);

    int insert(ChannelMap record);

    ChannelMap selectByPrimaryKey(String channleName);

    List<ChannelMap> selectAll();

    int updateByPrimaryKey(ChannelMap record);
}