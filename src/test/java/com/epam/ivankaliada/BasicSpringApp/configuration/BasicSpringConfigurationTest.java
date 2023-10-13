package com.epam.ivankaliada.BasicSpringApp.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.SQLException;

@ActiveProfiles("dev")
@SpringBootTest
public class BasicSpringConfigurationTest {

    @Autowired
    private BasicSpringConfiguration basicSpringConfiguration;

    @Autowired
    private DataSource dataSource;

    @Test
    public void shouldTestDataSourceWhenPrimaryBeanIsMissing() throws SQLException {
        HikariDataSource hikariDataSource = (HikariDataSource) dataSource;

        Assertions.assertEquals("devUsername", hikariDataSource.getUsername());
        Assertions.assertEquals("devPassword", hikariDataSource.getPassword());
    }

}
