package com.zhuoqu.slg.data.bi.stats.sql.resource.detail;

import com.zhuoqu.slg.data.bi.stats.bean.Resource;
import com.zhuoqu.slg.data.bi.stats.mapper.ResourceMapper;
import com.zhuoqu.slg.data.bi.stats.sql.StatsTask;
import com.zhuoqu.slg.data.bi.stats.util.BeansUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @Author: chenzhimin
 * @Date: 2020/10/26 12:11
 */
public class ResourceTask implements StatsTask {

    private  static Logger logger = LoggerFactory.getLogger(ResourceTask.class);

    private String modeSQL1 = "select day , server_name , server_id, item_id, op_code , sum(`change`) as count from `bi_resource_%s`  where day='%s' group by day , server_name , server_id, item_id, op_code ";

//
//    private String modeSQL2 = "select day , server_name , server_id, item_id, op_code as '-1', sum(`change`) as count from `bi_resource_%s`  where day='%s' group by day , server_name , server_id, item_id, op_code ";






    @Override
    public void doStatsTask(String fromDay, String toDay) {


        List<Resource> resourcesOne =  new ArrayList<>();

        JdbcTemplate jdbcTemplate = BeansUtil.buildFactory().getBean("jdbcTemplateBI", JdbcTemplate.class);

        String sql1 = String.format(modeSQL1, fromDay , fromDay);

        logger.info(sql1);
        List<Resource> resourceList1 = jdbcTemplate.query(sql1 , new ResourceMapper());

        resourcesOne.addAll(resourceList1);



//        String sql2 = String.format(modeSQL2, fromDay , fromDay);
//
//        logger.info(sql2);
//        List<Resource> resourceList2 = jdbcTemplate.query(sql2 , new ResourceMapper());
//
//        resourcesOne.addAll(resourceList2);






        if(ObjectUtils.isEmpty(resourcesOne)){
            return ;
        }

        JdbcTemplate jdbcTemplateStats = BeansUtil.buildFactory().getBean("jdbcTemplateStats", JdbcTemplate.class);

        resourcesOne.forEach( e-> {

            try {

                String sql_ = e.toSQL();
                logger.info(sql_);
                jdbcTemplateStats.update(sql_);

            }catch (Exception exception){
                logger.error(exception.getMessage(), exception);
            }


        });


    }
}
