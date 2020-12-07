package com.zhuoqu.slg.data.bi.stats.bean;

import com.zhuoqu.slg.data.bi.stats.constant.FiledPool;

/**
 * Description:
 *
 * @Author: chen_zhi_min
 * @Date: 2020/10/26 11:31
 */
public class Login implements  SQLBean{

    /** 日期*/
    private String day ;

    /** 服务器名称*/
    private String serverName ;

    /** 服务器id*/
    private String serverId ;

    /** 渠道编号*/
    private int channleId = FiledPool.DEFAULT_VAL ;

    /** 类型*/
    private int  type = 1 ;

    /** 统计结果*/
    private int count = 0 ;


    @Override
    public String toSQL() {

        String sql = "replace into `login_count`(`day`,`server_name`,`server_id`,`channel_id`,`type`,`count`)values('%s','%s','%s','%s','%s','%s')   ";
        return String.format(sql , day , serverName , serverId , channleId , type , count);
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
