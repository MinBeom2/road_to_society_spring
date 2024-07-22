package example.main.controllers.advice;

import example.main.controllers.PaymentController;
import example.main.exceptions.NotEnoughMoneyException;
import example.main.model.ErrorDetails;
import example.main.model.PaymentDetails;
import example.main.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("not enough money to make the payment");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}