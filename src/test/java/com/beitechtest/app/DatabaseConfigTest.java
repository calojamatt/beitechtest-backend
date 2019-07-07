package com.beitechtest.app;

import com.beitechtest.app.config.DatabaseConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.sql.DataSource;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-dev.properties")
public class DatabaseConfigTest {

    @Autowired
    private DatabaseConfig databaseConfig;

    @Test
    public void getDataSource() throws Exception {
        DataSource dataSource = databaseConfig.getDataSource();
        Assert.notNull(dataSource.getConnection(), "Connection is null");
    }

    @Test
    public void getSessionFactory() throws Exception {
        DataSource dataSource = databaseConfig.getDataSource();
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        Assert.notNull(sessionBuilder.buildSessionFactory(), "Session Factory is null");
    }

    @Test
    public void getTransactionManager() throws Exception {
        DataSource dataSource = databaseConfig.getDataSource();
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionBuilder.buildSessionFactory());
        Assert.notNull(transactionManager, "Transaction Manager is null");
    }
}