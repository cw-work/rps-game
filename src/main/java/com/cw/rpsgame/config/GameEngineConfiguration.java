package com.cw.rpsgame.config;

import com.cw.rpsgame.strategy.GameEngine;
import com.cw.rpsgame.strategy.SimpleGameEngine;
import com.cw.rpsgame.strategy.SimpleGameStrategy;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
public class GameEngineConfiguration {

    @Bean
    public GameEngine gameEngine() {
        return SimpleGameEngine.builder().gameStrategy(new SimpleGameStrategy()).build();
    }
}
