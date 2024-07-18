package aspects;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("logging aspect: calling the intercepted method");

        Object returnedValue= joinPoint.proceed();

        logger.info("logging aspect: method executed and returned "+returnedValue);

        return returnedValue;
    }
}
