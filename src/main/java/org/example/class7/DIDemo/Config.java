package org.example.class7.DIDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@ComponentScan
@Configuration
public class Config {
    private ToyotaEngine toyotaEngine;
    private Tyres tyres;
    @Bean
    public ToyotaEngine toyotaEngine(){
        return new ToyotaEngine("Toyota", 10000.0);
    }

    @Bean
    public Tyres tyres() {
        return new Tyres("TVS", "India", "Made in India");
    }

}
