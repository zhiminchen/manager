package com.zhuoqu.slg.data.bi.stats.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {

    @Bean
    JdbcTemplate jdbcTemplateBI(@Qualifier("biDataSource") DataSource gameDataSource) {
        return new JdbcTemplate(gameDataSource);
    }



    @Bean
    JdbcTemplate jdbcTemplateStats(@Qualifier("statsDataSource") DataSource gameDataSource) {
        return new JdbcTemplate(gameDataSource);
    }




}
