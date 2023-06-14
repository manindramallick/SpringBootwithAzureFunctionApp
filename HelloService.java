package org.example.functions;


import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String show(String str){
        return "Hello :"+str;
    }
}
