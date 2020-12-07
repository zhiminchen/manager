package com.zhuoqu.slg.data.bi.stats.sql;

/**
 * Description: 统计任务
 *
 * @Author: chen_zhi_min
 * @Date: 2020/10/26 10:40
 */
public interface StatsTask {

    /**
     * 做统计任务
     *
     */
    void doStatsTask(String fromDay , String toDay);

}
