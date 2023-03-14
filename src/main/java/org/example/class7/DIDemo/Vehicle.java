package org.example.class7.DIDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    IEngine engine;
    Tyres tyre;

    public Vehicle(IEngine engine, Tyres tyre)
    {
        System.out.println("instantiated via constructor");
        this.engine = engine;
        this.tyre = tyre;
    }

    public Vehicle() {}

    @Override
    public String toString()
    {
        return engine + " " + tyre;
    }

}
