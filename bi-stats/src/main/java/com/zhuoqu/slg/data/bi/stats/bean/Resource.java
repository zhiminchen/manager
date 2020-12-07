package com.zhuoqu.slg.data.bi.stats.bean;

import com.zhuoqu.slg.data.bi.stats.constant.FiledPool;

/**
 * Description:
 *
 * @Author: chen_zhi_min
 * @Date: 2020/10/26 11:52
 */
public class Resource implements  SQLBean{

    /** 日期*/
    private String day ;

    /** 服务器名称*/
    private String serverName ;

    /** 服务器id*/
    private String serverId ;


    /** 渠道编号*/
    private int channleId = FiledPool.DEFAULT_VAL ;


    /** 资源id*/
    private int resourceId ;

    /** 操作编号*/
    private int opCode = FiledPool.DEFAULT_VAL;

    /** 统计结果*/
    private long count ;


    @Override
    public String toSQL() {

        String sql = "replace into `resource_count`(`day`,`server_name`,`server_id`,`channel_id`,`resource_id`,`op_code` , `count`)values('%s','%s','%s','%s','%s','%s','%s')" ;
        return String.format(sql , day , serverName , serverId , channleId , resourceId , opCode , count);
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public int getChannleId() {
        return channleId;
    }

    public void setChannleId(int channleId) {
        this.channleId = channleId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getOpCode() {
        return opCode;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
