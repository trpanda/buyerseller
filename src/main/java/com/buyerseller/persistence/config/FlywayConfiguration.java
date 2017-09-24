package com.buyerseller.persistence.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class FlywayConfiguration
{

    @Autowired
    private DataSource ds;

    /**
     * @return Flyway
     */
    @Bean
    public Flyway flyway()
    {
        Flyway flyway = new Flyway();
        flyway.setDataSource(this.ds);
        flyway.migrate();
        return flyway;
    }

    /**
     * @return JdbcTemplate
     */
    @Bean
    @DependsOn("flyway")
    public JdbcTemplate template()
    {
        JdbcTemplate template = new JdbcTemplate(this.ds);
        return template;
    }
}
