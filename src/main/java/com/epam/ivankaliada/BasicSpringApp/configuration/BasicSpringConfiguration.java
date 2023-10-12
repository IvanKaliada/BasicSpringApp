package com.epam.ivankaliada.BasicSpringApp.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
public class BasicSpringConfiguration {

    @Profile("qa")
    @Primary
    @Bean(name = "qaDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.qa")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Profile("qa")
    @Primary
    @Bean(name = "qaDataSource")
    public DataSource primaryDataSource(@Qualifier("qaDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Profile("dev")
    @Bean(name = "devDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.dev")
    public DataSourceProperties secondaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Profile("dev")
    @ConditionalOnMissingBean(name = "qaDataSource")
    @Bean(name = "devDataSource")
    public DataSource secondaryDataSource(@Qualifier("devDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}
