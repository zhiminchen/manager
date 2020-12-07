package com.zhuoqu.slg.data.bi.stats.quartz.job;

import com.zhuoqu.slg.data.bi.stats.service.TaskServie;
import com.zhuoqu.slg.data.bi.stats.util.BeansUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * Description: 跨天定时job
 *
 * @Author: chen_zhi_min
 * @Date: 2020/10/16 16:08
 */
@Component
public class SatsJob implements Job {



    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {


        TaskServie taskServie = BeansUtil.buildFactory().getBean(TaskServie.class);
        taskServie.startJob();

    }
}
