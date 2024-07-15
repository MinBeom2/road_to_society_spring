package config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import services.CommentService;

@Configuration
@ComponentScan(basePackages = {"services", "repository"})
public class ProjectConfig {
}
