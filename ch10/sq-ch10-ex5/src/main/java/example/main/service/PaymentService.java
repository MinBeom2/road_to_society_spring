package example.main.service;

import example.main.exceptions.NotEnoughMoneyException;
import example.main.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
