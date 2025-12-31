package ua.vholovetskyi.splitup;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;

public class SprLiquibase {

    @Bean
    public SpringLiquibase liquibaseCheck() {
        return new SpringLiquibase();
    }
}
