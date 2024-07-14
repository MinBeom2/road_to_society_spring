package main;

import configuration.ProjectConfiguration;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
       var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

       var comment = new Comment();
       comment.setAuthor("김민범");
       comment.setText("앙뇽");

       var commentService = context.getBean(CommentService.class);
       commentService.publishComment(comment);
    }
}