import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class CentralizedAuth
 {

    public static void main(String[] args) {
        SpringApplication.run(Exercise1.class, args);
    }

    // Custom Global Filter
    @Component
    static class LoggingFilter implements GlobalFilter {

        @Override
        public Mono<Void> filter(ServerWebExchange exchange,
                                 GatewayFilterChain chain) {

            System.out.println("Incoming Request : "
                    + exchange.getRequest().getURI());

            return chain.filter(exchange);
        }
    }
}
