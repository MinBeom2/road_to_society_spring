package aspects;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        logger.info("method " + methodName + " with parameters "+ Arrays.asList(arguments)+" will execute");

        Comment comment = new Comment();
        comment.setText("new text");
        Object [] newArguments= {comment};

        Object returnedByuMethod = joinPoint.proceed(newArguments);

        logger.info("method executed and returned "+returnedByuMethod);

        return "failed";
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
