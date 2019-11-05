package com.sumant.boot.learning;

import org.springframework.stereotype.Component;

@Component
public class APIServerFallback implements APIServer{

    @Override
    public String getData() {
        return "Data from fallback method";
    }

}
