package com.zhuoqu.slg.data.bi.stats.quartz;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chen_zhi_min
 * Date: 2020/1/8 12:19
 **/
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StatsQuartzScheduler quartzScheduler;


    /**
     * 初始启动quartz
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            quartzScheduler.startJob();
//            System.out.println("任务已经启动...");
        } catch (SchedulerException e) {
//            e.printStackTrace();
            logger.error(e.getMessage(), e);

        }
    }

    /**
     * 初始注入scheduler
     * @return
     * @throws SchedulerException
     */
    @Bean
    public Scheduler scheduler() throws SchedulerException{
        SchedulerFactory schedulerFactoryBean = new StdSchedulerFactory();
        return schedulerFactoryBean.getScheduler();
    }

}
