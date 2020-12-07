package com.zhuoqu.slg.data.bi.stats.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class LoginCount implements Serializable {
    private Date day;

    private String serverName;

    private String serverId;

    private Integer channelId;

    private Integer type;

    private Integer count;

    private static final long serialVersionUID = 1L;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName == null ? null : serverName.trim();
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId == null ? null : serverId.trim();
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", day=").append(day);
        sb.append(", serverName=").append(serverName);
        sb.append(", serverId=").append(serverId);
        sb.append(", channelId=").append(channelId);
        sb.append(", type=").append(type);
        sb.append(", count=").append(count);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}