package com.zhuoqu.slg.data.bi.stats;


import com.zhuoqu.slg.data.bi.stats.service.TaskExecutorService;
import com.zhuoqu.slg.data.bi.stats.service.TaskServie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 三方启动项，就是spring-boot 启动完以后，启动自定义类或是服务器的入口点
 *
 *
 */
@Component
public class TripartiteBoost implements CommandLineRunner {

    private  static Logger logger = LoggerFactory.getLogger(TripartiteBoost.class);

    @Autowired
    private TaskServie taskServie;


    @Override
    public void run(String... args) throws Exception {

        taskServie.init();

        TaskExecutorService.getInstance() .init();

//
//        ServerHttpMapper serverHttpMapper = BeansUtil.buildFactory().getBean(ServerHttpMapper.class);
//
//        List<ServerHttp> serverHttpList = serverHttpMapper.selectAll();
//
//
//        serverHttpList.forEach(e-> {
//            System.out.println(e.toString());
//        });



        logger.info("服务器启动完成！！！！！！！！！！！！！！！！！！！！！！");



    }


}
