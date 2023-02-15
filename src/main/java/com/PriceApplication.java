package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author zjc
 */
@SpringBootApplication
public class PriceApplication {
    public static void main(String[] args) {

        SpringApplication.run(PriceApplication.class, args);

    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
