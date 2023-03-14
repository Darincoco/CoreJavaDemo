package org.example.class7.DIDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String args[])
    {
        ApplicationContext content
                = new AnnotationConfigApplicationContext(Config.class);

        // Instantiating the obj1 via Constructor DI
        Vehicle obj1 = content.getBean(Vehicle.class);

        System.out.println(obj1);
    }
}
