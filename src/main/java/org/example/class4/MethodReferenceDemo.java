package org.example.class4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class MethodReferenceDemo {

    public static void main(String[] args) {

        // Reference to a static method
        // Function
        Function<Integer, Integer> getArea = Math::square;
        Function<Integer, Integer> area = t -> t * t;
        int res1 = getArea.apply(5);
        int res = area.apply(5);
        System.out.println("Using reference method: " + res1);
        System.out.println("Using lambda expression: " + res);

        // Predicate
        String str = "Hello World";
        Predicate<String> method1 = str::contains;
        Predicate<String> method11 = (s) -> {
            return s.contains("llo");
        };
        boolean res2 = method1.test("abc");
        boolean res3 = method11.test(str);
        System.out.println("\nUsing reference method: " + res2);
        System.out.println("Using lambda expression: " + res3);

        // Consumer
        Consumer<String> method2 = (message) -> {
            System.out.println("\nMessages from Consumer: " + message);
        };
        method2.accept("Hello World!");
        Consumer<String>method21 = PrintMsg::print;
        method21.accept("Hello world");

        //Supplier
        Supplier<String> method3 = () -> {return "Hello World";};
        String res4 = method3.get();
        Supplier<String> method4 = PrintMsg::print;
        String res5 = method4.get();
        System.out.println("\nUsing lambda expression: " + res4);
        System.out.println("Using reference method: " + res5);

        // Reference to an instance method of an object of a particular type
        Person Alex = new Person(20);
        getAge getAge = Person::getAge;
        int age = getAge.get(Alex);
        System.out.println(age);

        // Reference to an instance method of an arbitrary object of a particular type
        BiFunction<String, String, Boolean> startsWith = String::startsWith;
        boolean startsWithA = startsWith.apply("apple", "a");
        System.out.println("'apple' starts with 'a': " + startsWithA);

        // Reference to a constructor
        Supplier<String> stringSupplier = String::new;
        String emptyString = stringSupplier.get();
        System.out.println("Empty string: '" + emptyString + "'");
    }
}

class Math{
    public static int square(int num) {
        return num * num;
    }
}

class PrintMsg{
    public static void print(String msg) {
        System.out.println("Messages from Consumer using reference method: " + msg);
    }

    public static String print() {
        return "This msg is from reference method";
    }
}

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface getAge {
    public int get(Person p);
}


