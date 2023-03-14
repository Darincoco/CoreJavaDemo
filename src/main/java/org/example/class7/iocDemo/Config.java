package org.example.class7.iocDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Config {
    @Bean
    public Livingroom livingroom() {
        return new Livingroom(400, "square");
    }

    @Bean
    public Bathroom bathroom() {
        return new Bathroom(500, false);
    }
}
