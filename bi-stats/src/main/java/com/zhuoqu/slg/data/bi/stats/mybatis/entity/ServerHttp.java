package com.zhuoqu.slg.data.bi.stats.mybatis.entity;

import java.io.Serializable;

public class ServerHttp implements Serializable {
    private Integer id;

    private Integer serverType;

    private String serverName;

    private String serverIp;

    private Integer serverWebPort;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName == null ? null : serverName.trim();
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    public Integer getServerWebPort() {
        return serverWebPort;
    }

    public void setServerWebPort(Integer serverWebPort) {
        this.serverWebPort = serverWebPort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serverType=").append(serverType);
        sb.append(", serverName=").append(serverName);
        sb.append(", serverIp=").append(serverIp);
        sb.append(", serverWebPort=").append(serverWebPort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}