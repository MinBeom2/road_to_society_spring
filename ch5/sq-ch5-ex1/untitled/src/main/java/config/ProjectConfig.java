package config;

import org.springframework.context.annotation.Bean;
import services.CommentService;

public class ProjectConfig {

    @Bean
    public CommentService commentService(){
        return new CommentService();
    }
}