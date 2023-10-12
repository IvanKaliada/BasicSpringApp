package com.epam.ivankaliada.BasicSpringApp.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class BasicSpringConfiguration {

    @Profile("qa")
    @Primary
    @Bean(name = "qaDataSourceProperties")
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
