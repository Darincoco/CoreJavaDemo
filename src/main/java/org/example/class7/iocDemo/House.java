package org.example.class7.iocDemo;

import org.springframework.stereotype.Component;

@Component
public class House {
    Bathroom bathroom;
    Livingroom livingroom;

    public House(Bathroom bathroom, Livingroom livingroom) {
        this.bathroom = bathroom;
        this.livingroom = livingroom;
    }

    @Override
    public String toString() {
        return "House{" +
                "bathroom=" + bathroom +
                ", livingroom=" + livingroom +
                '}';
    }
}
