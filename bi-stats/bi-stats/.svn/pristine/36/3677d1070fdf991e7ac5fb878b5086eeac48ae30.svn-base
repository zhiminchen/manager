package com.zhuoqu.slg.data.bi.stats.mybatis.dao;

import com.zhuoqu.slg.data.bi.stats.mybatis.entity.ResourceCount;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceCountMapper {
    int deleteByPrimaryKey(@Param("day") Date day, @Param("serverName") String serverName, @Param("serverId") String serverId, @Param("channelId") Integer channelId, @Param("resourceId") Integer resourceId, @Param("opCode") Integer opCode);

    int insert(ResourceCount record);

    ResourceCount selectByPrimaryKey(@Param("day") Date day, @Param("serverName") String serverName, @Param("serverId") String serverId, @Param("channelId") Integer channelId, @Param("resourceId") Integer resourceId, @Param("opCode") Integer opCode);

    List<ResourceCount> selectAll();

    int updateByPrimaryKey(ResourceCount record);
}