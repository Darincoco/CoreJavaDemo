package org.example.class7.DIDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    IEngine engine;
    Tyres tyre;

    @Autowired
    public Vehicle(IEngine engine, Tyres tyre)
    {
        System.out.println("instantiated via constructor");
        this.engine = engine;
        this.tyre = tyre;
    }

    public Vehicle() {
        System.out.println("via null constructor");
    }

    @Override
    public String toString()
    {
        return engine + " " + tyre;
    }

}
