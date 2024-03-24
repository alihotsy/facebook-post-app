package com.mycompany.facebookpost.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "db")
public class DbConnection {

    private String url;
    private String driver;
    private String userName;
    private String password;
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<? extends DataSource> config = DataSourceBuilder.create();
        config.url(url);
        config.driverClassName(driver);
        config.username(userName);
        config.password(password);
        return config.build();
    }
}
