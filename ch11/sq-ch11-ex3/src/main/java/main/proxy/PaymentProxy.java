package main.proxy;


import main.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class PaymentProxy {
    private final WebClient webClient;

    @Value("${name.service.url}")
    private String url;

    public PaymentProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(String requestId, Payment payment) {
        return webClient.post()
                .uri(url+"/payment")
                .header("requestId",requestId)
                .body(Mono.just(payment),Payment.class)
                .retrieve()
                .bodyToMono(Payment.class);
    }
}
