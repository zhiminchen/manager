package com.zhuoqu.slg.data.bi.stats.mapper;

import com.zhuoqu.slg.data.bi.stats.bean.Resource;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description:
 *
 * @Author: chenzhimin
 * @Date: 2020/10/26 12:06
 */
public class ResourceMapper  implements RowMapper<Resource> {


    @Override
    public Resource mapRow(ResultSet resultSet, int i) throws SQLException {


//        select day , server_name , server_id, item_id, op_code  sum(change)


        Resource resource = new Resource();
        resource.setDay(resultSet.getString(1));
        resource.setServerName(resultSet.getString(2));
        resource.setServerId(resultSet.getString(3));
        resource.setResourceId(resultSet.getInt(4));
        resource.setOpCode(resultSet.getInt(5));
        resource.setCount(resultSet.getLong(6));

        return resource;
    }





}
