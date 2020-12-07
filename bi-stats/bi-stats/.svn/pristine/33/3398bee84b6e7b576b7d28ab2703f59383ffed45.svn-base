package com.zhuoqu.slg.data.bi.stats.service;

import org.springframework.util.ObjectUtils;

import java.util.concurrent.*;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * 异步任务处理器
 *
 * Created by IntelliJ IDEA.
 *
 * @author: chenzhimin
 * Date: 2019/7/26 17:00
 **/
public class TaskExecutorService  {


    private TaskExecutorService() {
    }


    private static TaskExecutorService instance = null;


    /**
     * 通用任务队列
     */
    private static BlockingQueue<Runnable> commWorkQueue = new LinkedBlockingQueue<>(Integer.MAX_VALUE >> 4);




    private ExecutorService executorService;






    public static TaskExecutorService getInstance() {

        if (instance == null) {

            synchronized (TaskExecutorService.class) {

                if (instance == null) {
                    instance = new TaskExecutorService();

                }

            }
        }

        return instance;
    }


    public void init() {


        int maxCpuCore = Runtime.getRuntime().availableProcessors();


        if(ObjectUtils.isEmpty(executorService)){
            ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("executor-pool-%d").build();
            //启动固定线程池
            executorService = new ThreadPoolExecutor(maxCpuCore, 2 * maxCpuCore, 5L, TimeUnit.MILLISECONDS, commWorkQueue, namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        }



    }



    /**
     * 一般任务处理
     *
     * @param task
     */
    public void generalTreatment(Runnable task) {

        if (task == null) {
            return;
        }

        this.executorService.submit(task);
    }



}
