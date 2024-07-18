package services;

import aspects.ToLog;
import model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("Publishing comment:"+comment.getText());
        return "SUCCESS";
    }

    @ToLog
    public void deleteComment(Comment comment){
        logger.info("deleting comment:"+comment.getText());
    }

    public void editComment(Comment comment){
        logger.info("editing comment:"+comment.getText());
    }

    public void setLogger(Logger logger){
        this.logger=logger;
    }
}
