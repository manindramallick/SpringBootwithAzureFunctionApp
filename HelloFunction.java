package org.example.functions;

import org.springframework.stereotype.Component;

import java.util.function.Function;

public class HelloFunction implements Function<String, String> {

    private final HelloService helloService;

    public HelloFunction(HelloService helloService){
        this.helloService=helloService;
    }

    @Override
    public String apply(String str) {
        return helloService.show(str);
    }
}