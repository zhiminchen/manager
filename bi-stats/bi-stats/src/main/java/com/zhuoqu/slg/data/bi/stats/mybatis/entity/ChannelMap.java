package com.zhuoqu.slg.data.bi.stats.mybatis.entity;

import java.io.Serializable;

public class ChannelMap implements Serializable {
    private String channleName;

    private Integer channelId;

    private static final long serialVersionUID = 1L;

    public String getChannleName() {
        return channleName;
    }

    public void setChannleName(String channleName) {
        this.channleName = channleName == null ? null : channleName.trim();
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channleName=").append(channleName);
        sb.append(", channelId=").append(channelId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}