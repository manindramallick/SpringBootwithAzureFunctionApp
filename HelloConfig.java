package org.example.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    private final HelloService helloService;

    public HelloConfig(HelloService helloService){
        this.helloService=helloService;
    }

    @Bean
    public HelloFunction hello(){
        return new HelloFunction(helloService);
    }
}
