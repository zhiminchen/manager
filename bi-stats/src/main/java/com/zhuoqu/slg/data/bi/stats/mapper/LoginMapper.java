package com.zhuoqu.slg.data.bi.stats.mapper;

import com.zhuoqu.slg.data.bi.stats.bean.Login;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Description:
 *
 * @Author: chen_zhi_min
 * @Date: 2020/10/26 11:38
 */
public class LoginMapper implements RowMapper<Login> {


    @Override
    public Login mapRow(ResultSet resultSet, int i) throws SQLException {

//        select day , server_name , server_id, action_type,  count(distinct user_id) as count from `bi_login_%s`  where day='%s' group by day , server_name , server_id, action_type ";

        Login login = new Login();
        login.setDay(resultSet.getString(1));
        login.setServerName(resultSet.getString(2));
        login.setServerId(resultSet.getString(3));
        login.setType(resultSet.getInt(4));
        login.setCount(resultSet.getInt(5));

        return login;
    }
}
