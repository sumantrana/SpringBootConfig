package com.sumant.boot.learning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class SpringBootConfigApplication {

    private Environment env;

    public SpringBootConfigApplication(Environment env){

        this.env = env;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

//    @Override
//    public void run(String... args) throws Exception {
//        //System.out.println("Sumant Test Property: " + env.getProperty("test.property"));
//
//    }

//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient){
//        return args -> {
//            for ( int i = 0; i < 10; i++ ) {
//                ServiceInstance instance = loadBalancerClient.choose("springboot-apiserver-service");
//                URI serviceURI = URI.create(String.format("http://%s:%s/data", instance.getHost(), instance.getPort()));
//                System.out.println("Service URI using Ribbon Load Balancer: " + serviceURI);
//                //String url = "http://".concat(env.getProperty("remote.host")).concat(":").concat(env.getProperty("remote.port")).concat("/data");
//                //System.out.println("Remote url: " + url);
//                String data = restTemplate.getForObject(serviceURI, String.class);
//                System.out.println("Remote call output: " + data);
//            }
//        };
//    }

//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate, DiscoveryClient discoveryClient){
//        return args -> {
//            System.out.println("Discovery Services: " + discoveryClient.getServices());
//            List<ServiceInstance> serviceInstances = discoveryClient.getInstances("springboot-apiserver-service");
//            ServiceInstance instance = serviceInstances.get(0);
//            URI serviceURI = URI.create(String.format("http://%s:%s/data", instance.getHost(), instance.getPort()));
//            System.out.println("Service URI using Service Discovery: " + serviceURI);
//            String data = restTemplate.getForObject(serviceURI, String.class);
//            System.out.println("Remote call output: " + data);
//        };
//    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate, APIServer apiServer){
        return args -> {
            String data = apiServer.getData();
            System.out.println("Feign remote call output: " + data);
        };
    }

}
