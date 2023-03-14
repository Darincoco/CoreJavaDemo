package org.example.class7.DIDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Config {
    @Bean
    public ToyotaEngine toyotaEngine(){
        return new ToyotaEngine("Toyota", 10000.0);
    }

    @Bean
    public Tyres tyres() {
        return new Tyres("TVS", "India", "Made in India");
    }

}
