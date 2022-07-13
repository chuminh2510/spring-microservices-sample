package com.example.bookservice.config;

import com.example.bookservice.entity.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${POSTGRES_HOST}")
    private String host;
    @Value("${POSTGRES_DB}")
    private String dbName;
    @Value("${POSTGRES_USER}")
    private String username;
    @Value("${POSTGRES_PASSWORD}")
    private String password;

//    @Bean
//    public DataSource getDataSource() {
//        String url = getDataSourceUrl();
//        System.out.println("HOST:" + url + ":End");
//        System.out.println("Name:" + username + ":End");
//        System.out.println("Password:" + password + ":End");
//        return DataSourceBuilder.create()
//                .driverClassName("org.postgresql.Driver")
//                .url(getDataSourceUrl())
//                .username(username)
//                .password(password)
//                .build();
//    }
//
//    private String getDataSourceUrl() {
//        return "jdbc:postgresql://" + host + "/" + dbName;
//    }

    @Bean
    public Book testBook() {
        System.out.println("HOST: " + host);
        return new Book();
    }
}
