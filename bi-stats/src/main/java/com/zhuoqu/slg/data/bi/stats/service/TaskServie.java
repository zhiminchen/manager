package com.zhuoqu.slg.data.bi.stats.service;

import cn.hutool.core.collection.ConcurrentHashSet;
import com.zhuoqu.slg.data.bi.stats.sql.StatsTask;
import com.zhuoqu.slg.data.bi.stats.sql.login.detail.LoginTask;
import com.zhuoqu.slg.data.bi.stats.sql.resource.detail.ResourceTask;
import com.zhuoqu.slg.data.bi.stats.util.TimeUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @Author: chen_zhi_min
 * @Date: 2020/10/26 14:28
 */
@Service
public class TaskServie {


    /** 任务集合*/
    private Set<Object> taskSet = new ConcurrentHashSet();

    /** 任务集合的列表*/
    private List<StatsTask> statsTaskList = new ArrayList<>();




    public void init() {

        this.addTask(new LoginTask());
        this.addTask(new ResourceTask());

    }


    /**
     * 添加任务
     *
     * @param statsTask
     */
    public void addTask(StatsTask statsTask){

        if(ObjectUtils.isEmpty(statsTask)){
            return ;
        }


        if(taskSet.contains(statsTask.getClass())){
            return ;
        }

        taskSet.add(statsTask.getClass());


        statsTaskList.add(statsTask);


    }


    /**
     * 启动任务
     *
     */
    public void startJob(){


        String currDay = TimeUtils.formatCurrDay();
        String toDay = TimeUtils.dayPlus(currDay , -1);


        statsTaskList.forEach(e -> {
//            e.doStatsTask("2020-10-24" , "2020-10-24");

            TaskExecutorService.getInstance().generalTreatment(() -> {
                e.doStatsTask(toDay, toDay);
            });


        });


    }




}
