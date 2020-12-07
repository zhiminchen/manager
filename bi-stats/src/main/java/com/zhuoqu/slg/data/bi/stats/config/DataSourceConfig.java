package com.zhuoqu.slg.data.bi.stats.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Configuration
//spring.datasource.hikari.
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix="hikari.bi")
    DataSource biDataSource(){

        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix="hikari.stats")
    @Primary
    DataSource statsDataSource(){

        return DataSourceBuilder.create().build();
    }





}
