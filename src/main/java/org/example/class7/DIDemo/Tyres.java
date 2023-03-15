package org.example.class7.DIDemo;

import org.springframework.stereotype.Component;

public class Tyres {

    String name;
    String place;
    String message;

    public Tyres(String name, String place, String message) {
        this.name = name;
        this.place = place;
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "This is Tyre object: "
                + name + " " + place
                + " " + message;
    }
}
