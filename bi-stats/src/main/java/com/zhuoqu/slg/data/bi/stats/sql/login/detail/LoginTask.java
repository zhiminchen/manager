package com.zhuoqu.slg.data.bi.stats.sql.login.detail;

import com.zhuoqu.slg.data.bi.stats.bean.Login;
import com.zhuoqu.slg.data.bi.stats.mapper.LoginMapper;
import com.zhuoqu.slg.data.bi.stats.sql.StatsTask;
import com.zhuoqu.slg.data.bi.stats.util.BeansUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Description:
 *
 * @Author: chen_zhi_min
 * @Date: 2020/10/26 10:43
 */
public class LoginTask implements StatsTask {

    private  static Logger logger = LoggerFactory.getLogger(LoginTask.class);


    private String modeSQL = "select day , server_name , server_id, action_type,  count(distinct user_id) as count from `bi_login_%s`  where day='%s' group by day , server_name , server_id, action_type ";


    @Override
    public void doStatsTask(String fromDay , String toDay) {

        JdbcTemplate jdbcTemplate = BeansUtil.buildFactory().getBean("jdbcTemplateBI", JdbcTemplate.class);

        String sql = String.format(modeSQL , fromDay , fromDay);

        logger.info(sql);

        List<Login> loginList = jdbcTemplate.query(sql , new LoginMapper());


        if(ObjectUtils.isEmpty(loginList)){
            return ;
        }

        JdbcTemplate jdbcTemplateStats = BeansUtil.buildFactory().getBean("jdbcTemplateStats", JdbcTemplate.class);


        loginList.forEach( e-> {
            try {

                String sql_ = e.toSQL();
                logger.info(sql_);
                jdbcTemplateStats.update(sql_);

            }catch (Exception exception){

                logger.error(exception.getMessage() , exception);
            }

        });


    }
}
