package main;

import model.Comment;
import proxies.EmailCommentNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
       var commentRepository = new DBCommentRepository();
       var commentNotification = new EmailCommentNotificationProxy();

       var commentService = new CommentService(commentRepository, commentNotification);

       var comment = new Comment();
       comment.setAuthor("MinBeom");
       comment.setText("ㅇㅅㅇ");

       commentService.publishComment(comment);
    }
}