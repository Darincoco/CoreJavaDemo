package org.example.class3;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionExampleWithFunctionalInterface {
    public static void main(String[] args) {
        // Example using Predicate interface
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 5 even? " + isEven.test(5)); // Output: Is 5 even? false
        System.out.println("Is 10 even? " + isEven.test(10)); // Output: Is 10 even? true

        // Example using Supplier interface
        Supplier<Integer> randomNumber = () -> (int) (Math.random() * 100);
        System.out.println("Random number: " + randomNumber.get()); // Output: Random number: (some random number between 0 and 99)

        // Example using Consumer interface
        Consumer<String> printMessage = message -> System.out.println(message);
        printMessage.accept("Hello, world!"); // Output: Hello, world!

        // Example using Function interface
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Hello, world!': " + stringLength.apply("Hello, world!")); // Output: Length of 'Hello, world!': 13
    }
}
