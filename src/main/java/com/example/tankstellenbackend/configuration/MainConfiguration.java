package com.example.tankstellenbackend.configuration;

import com.example.tankstellenbackend.model.Bon;
import com.example.tankstellenbackend.model.Tankstelle;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.File;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.tankstellenbackend")
@EnableTransactionManagement
public class MainConfiguration {

    @Value("${spring.datasource.driver}")
    String driverClassName;

    @Value("${spring.datasource.url}")
    String databaseUrl;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Bean
    public DataSource dataSource() {
        /**
         * sollte irgendwann durch BoneCpDataSourcePool ausgetauscht werden!!!
         * Important for test purposes with several connections at the same time.
         */
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setSuppressClose(true);
        return dataSource;
    }

    @Bean
    public Bon bon(){
        Bon exampleBon = new Bon("Aral Tankstelle", (float)1.359, (float)25.7, (float)34.93);
        return exampleBon;
    }

    @Bean(name = "aral")
    public Tankstelle tankstelleAral(){
        Tankstelle aral = new Tankstelle("Aral", new File("classpath:images/aral.jpg"), "Bonn 53227");
        return aral;
    }

    @Bean(name = "esso")
    public Tankstelle tankstelleEsso(){
        Tankstelle esso = new Tankstelle("Aral", new File("classpath:images/aral.jpg"), "Bonn 53227");
        return esso;
    }

    @Bean(name = "shell")
    public Tankstelle tankstelleShell(){
        Tankstelle shell = new Tankstelle("Aral", new File("classpath:images/aral.jpg"), "Bonn 53227");
        return shell;
    }

    @Autowired
    @Bean(value = "liquibase")
    public SpringLiquibase liquibaseBean(DataSource dataSource){
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog("classpath:db/changelog.yml");
        springLiquibase.setDataSource(dataSource);
        return springLiquibase;
    }

}
