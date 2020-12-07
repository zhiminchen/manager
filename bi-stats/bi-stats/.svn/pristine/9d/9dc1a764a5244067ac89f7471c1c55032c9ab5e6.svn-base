package com.zhuoqu.slg.data.bi.stats.mybatis.dao;

import com.zhuoqu.slg.data.bi.stats.mybatis.entity.LoginCount;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginCountMapper {
    int deleteByPrimaryKey(@Param("day") Date day, @Param("serverName") String serverName, @Param("serverId") String serverId, @Param("channelId") Integer channelId, @Param("type") Integer type);

    int insert(LoginCount record);

    LoginCount selectByPrimaryKey(@Param("day") Date day, @Param("serverName") String serverName, @Param("serverId") String serverId, @Param("channelId") Integer channelId, @Param("type") Integer type);

    List<LoginCount> selectAll();

    int updateByPrimaryKey(LoginCount record);
}