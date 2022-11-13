package com.example.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
public class PersistenceConfiguration {
    @Bean
    DataSource dataSource()
    {
        DataSourceBuilder dsBuilder = DataSourceBuilder.create();
//
        dsBuilder.url ("jdbc:postgresql://localhost:5432/conference_app");
        dsBuilder.username ("postgres");
        dsBuilder.password ("01005883275");
        System.out.println("am here");
        return (DataSource) dsBuilder.build();
    }
//    public DataSource dataSource()
//    {
//        DataSourceBuilder builder=DataSourceBuilder.create();
//        builder.url("jdbc:postgresql://localhost:5432/conference_app");
//        System.out.println("my databas");
//    }
}
