package com.dashboard.documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@OpenAPIDefinition
@Component
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi(){
        return new OpenAPI().info(new Info().title("Employee Dashboard API").version("1-SNAPSHOT").license(new License().name("Licence")));
    }

    @Bean
    public GroupedOpenApi userGroup(){
        return GroupedOpenApi.builder().setGroup("Users").pathsToMatch("/api/v1/users/**").build();
    }

    @Bean
    public GroupedOpenApi employeeGroup(){
        return GroupedOpenApi.builder().setGroup("Employees").pathsToMatch("/api/v1/employees/**").build();
    }

    @Bean
    public GroupedOpenApi taskGroup(){
        return GroupedOpenApi.builder().setGroup("Tasks").pathsToMatch("/api/v1/tasks/**").build();
    }

    @Bean
    public GroupedOpenApi messageGroup(){
        return GroupedOpenApi.builder().setGroup("Messages").pathsToMatch("/api/v1/messages/**").build();
    }

    @Bean
    public GroupedOpenApi announcementGroup(){
        return GroupedOpenApi.builder().setGroup("Announcements").pathsToMatch("/api/v1/announcements/**").build();
    }

    @Bean
    public GroupedOpenApi attendanceGroup(){
        return GroupedOpenApi.builder().setGroup("Attendance").pathsToMatch("/api/v1/attendance/**").build();
    }
}
