

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class LoadBalance {

    public static void main(String[] args) {
        SpringApplication.run(Exercise2.class, args);
    }

    @Configuration
    @LoadBalancerClient(name = "example-service")
    static class LoadBalancerConfiguration {

        @Bean
        ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(
                Environment environment,
                LoadBalancerClientFactory factory) {

            String name = environment.getProperty(
                    LoadBalancerClientFactory.PROPERTY_NAME);

            return new RandomLoadBalancer(
                    factory.getLazyProvider(
                            name,
                            ServiceInstanceListSupplier.class),
                    name);
        }
    }
}

