package by.bstu.fit.zholnerovich.course.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@Configuration
@EnableJpaRepositories("by.bstu.fit.zholnerovich.course.server.repository")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("by.bstu.fit.zholnerovich.course.server")
public class DatabaseConfig {

    @Resource
    private Environment env;
}
