package ru.info_system_and_services.household_appliances_register.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI usersOpenAPI() {
        return new OpenAPI().info(new Info().title("Household Appliances API")
                .description("Household Appliances API")
                .version("1.0"));
    }
}
