package org.example.class3;

import org.example.exception.UserNotFoundException;

import java.io.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Class3Notes {
/*
1. Exception: can be handles (while errors can not be handled)
              But error and exception both can be throw because they are from throwable

                           ┌─────────┐
                           │ object  │
                           └────┬────┘
                           ┌────┴────┐
                      ┌────┤throwable├────┐
                      │    └─────────┘    │
                      │                   │
                      │                   │
                ┌─────┴─────┐        ┌────┴────┐    ┌──────────┐
                │ Exception │        │ error   ├────┤and so on │
                └┬───────┬──┘        └─┬───────┤    └──────────┘
                 │       │             │       │
        ┌────────┴┐ ┌────┴──────┐  ┌───┴────┐ ┌┴────────┐
        │ checked │ │ unchecked │  │ virtual│ │assertion│
        │Exception│ │ exception │  │ error  │ │  error  │
        └─────────┘ └───────────┘  └────────┘ └─────────┘
    checked exception: compile time exception
                       need to use try catch/ throws to handle the exception
                       ClassNotFoundException, IOException, SQLException,
    uncheck exception: runtime exception
                       ArithmeticException (when 1 / 0), ArrayIndexOutOfBoundsException, ClassCastException,
                       NullPointerException
    use case:
         1. public static void main(String[] args){
                try {
                    fileReader("/");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

            public static void fileReader(String path) throws FileNotFoundException{

            }
         2. public static String stringModifier(String str) {
                if(str == null || str.length() == 0) {
                    throw new IllegalArgumentException();
                }
                return str;
            }
    customize exception:
        create a class and extends from Exception:
            public class UserNotFoundException extends RuntimeException{}
            public UserNotFoundException(){
                super();
            }

            public UserNotFoundException(String msg){
                super(msg + " this is a customized exception");
            }
        }
    finally block: will always run no matter what is in try block
                   try block must go with catch block or finally block or both blocks
    multiple catch: catch block can have many blocks(before Java 7), but only the one that first matches the exception
                    type is executed. We need to order the catch blocks properly.
                    After Java 7, we can put all exception in a catch block parameter by connecting with "|",
                    e.g. catch(ArithmeticException | NullPointerException | UserNotFoundException exc)
    try with resources * : If we want to close a connection(like JDBC), we need close() method at last, which will also
                           need try catch block. It is redundant.
                           e.g. public static void main(String[] args) {
                                    BufferedReader bf = null;
                                    try {
                                        bf = new BufferedReader(new FileReader("/"));
                                        bf.readLine();
                                    } catch (RuntimeException | FileNotFoundException exc){
                                        exc.printStackTrace();
                                    } finally{
                                        try {
                                            bf.close();
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                }
                           After Java 7, a new feature try with resources. Create recourses in parameters, it will
                           automatically close the connection at last.
                           Reason： BufferedReader extends Reader, Reader extends from Closeable, Closeable extends from
                                    AutoCloseable. In short, BufferedReader implements Closeable and AutoCloseable
                                    interface, overrides the close() method, put it in the try parameter.
                                    So if we put List<>() in try parameters, it is illegal because List not implement
                                    the Closeable interface.
                           For example: public static void main(String[] args) {
                                            try (
                                                    BufferedReader br = new BufferedReader(new FileReader("/"))
                                            ){
                                                br.readLine();
                                            } catch (FileNotFoundException e) {
                                                throw new RuntimeException(e);
                                            } catch (IOException e) {
                                                throw new RuntimeException(e);
                                            }
                                        }


2. Generics
        if we want to create Node with different data type, we don't need to write duplicate code, use generics
        NOTICE! We need to use WRAPPER TYPES in generics data type, no primitive data type
        WHY? data erase, while code compiling, cast data type to Object type
        Generics for class:
            class Node3<K, V> {
                K key;
                V value;

                public Node3(K key, V value) {
                    this.key = key;
                    this.value = value;
                }
            }
        Generics for method:
        Parameters in method should also in Object
            public static <E> E getFirstElement(E[] array) {
                return array[0];
            }
            Integer[] array= new Integer[] {1,2,3,4};
            Character[] charArray = new Character[] {'a', 'b', 'c', 'd'};
            int[][] twoDArray = new int[][]{{1,2,3}, {4}, {5}};

            System.out.println(getFirstElement(array));
            System.out.println(getFirstElement(charArray));
            // int not inherited from Object, but int[] inherited from Object
            System.out.println(Arrays.toString(getFirstElement(twoDArray)));    //this one will print
        Advanced: <?> / <A extends B> / <B super A>


3. Java 8 new features
    lambda expression
        format: (arguments) -> {method body}
        usage: 1. don't need a class to implement the interface, can use lambda expression
                  to define anonymous class and call abstract method
                    e.g. interface Workout{
                             public void deadlift();
                         }

                         Workout wk = () -> {
                             System.out.println("I will do deadlift");
                         };
                         wk.deadlift();
                2. define order in a set
                    Set<Integer> tr = new TreeSet<>((a, b) -> Integer.compare(a,b));
                    Set<Integer> tr2 = new TreeSet<>((a, b) -> b - a);  // not recommended, will cause overflow problem

    Functional Interface (interface can have many methods as wanted)
        @functionalInterface is optional, when annotated with functionalInterface, it will let the programme know it is
        a functional interface and help we check the interface correctness
        it has only one abstract method, if 2 methods in this interface, will throw error
        it usually combine functional interface with lambda expression, in another word, lambda express is the
        implementation of functional interface

        default concrete method: we can have as many concrete method as we want using default keyword, which is not
        allowed in normal interface.
          e.g.  @FunctionalInterface   // optional
                interface Drawable{
                    public void draw();

                    public default void drawCircle(){
                        System.out.println("Drawing a circle");
                    }

                    public default void drawLine(){
                        System.out.println("Drawing a line");
                    }
                }

        predefined functional interface:
        Predicate: only one abstract method: public Boolean test(T t);
                   Returns true if the input argument matches the predicate, otherwise false
        Function: only one abstract method: public R apply(T t);
                  Return one Object and apply to the datatype key
        Consumer: only one abstract method: public void accept(T t);
                  Return nothing
        Supplier: only one abstract method: public R get();
        BiPredicate: only one abstract method: public Boolean test(T t, U u);
        BiFunction<R, T, U>: only one abstract method: public R apply(T t, U u);
        e.g.BiFunction<Integer, Integer, Integer> myAdd = (a, b) -> {return a + b;};
            System.out.println(myAdd.apply(1, 2));
            Function<Integer, Integer> addOne = a -> a + 1;
            System.out.println(addOne.apply(1));

    Optional
        solve NPE problem
                String[] array = new String[2];
                String[] array = new String[] {"abc", "cdf"};
                if (array[0] == null) {
                    throw new IllegalArgumentException("the value is null");
                    System.out.println("from if code: the value is null");
                } else {
                    System.out.println(array[0]);
                }

                Optional opt = Optional.ofNullable(array[0]);
                System.out.println(opt.orElse("From optional: the value is null"));    // print not null case
                opt.orElseThrow(() -> new IllegalArgumentException("the value is null"));    // throw exception
        common method:
            empty(): create a optional with nothing in it
            of(): wraps a value, if null will throw no such element exception
            ofNullable(): wraps a value, null value can proceed
            isPresent():
            isEmpty():
            orElse():
            orElseThrow():





 */

    public static void main(String[] args) throws Throwable {
//        Node node = new Node(1, "Bob");       // node with int key and string value
//        Node2 node2 = new Node2(1.0, 'B');    // node 2 with double key and character value
//        // if we want to create Node with different data type, we don't need to write duplicate code, use generics
//        // NOTICE! We need to use WRAPPER TYPES in generics data type, no primitive data type
//        // WHY? data erase, while code compiling, cast data type to Object type
//        Node3<Integer, String> node3 = new Node3<>(1, "Bob");
//        Node3<Double, String> node4 = new Node3<>(1.0, "Bob");
//        Node3<Integer, Character> node5 = new Node3<>(1, 'B');
//
//        Integer[] array= new Integer[] {1,2,3,4};
//        Character[] charArray = new Character[] {'a', 'b', 'c', 'd'};
//        int[][] twoDArray = new int[][]{{1,2,3}, {4}, {5}};
//
//        System.out.println(getFirstElement(array));
//        System.out.println(getFirstElement(charArray));
//        System.out.println(Arrays.toString(getFirstElement(twoDArray)));

//        Workout wk = () -> {
//            System.out.println("I will do deadlift");
//        };
//        wk.deadlift();
//
//        Set<Integer> tr = new TreeSet<>((a, b) -> Integer.compare(a,b));
//        Set<Integer> tr2 = new TreeSet<>((a, b) -> b - a);  // not recommended, will cause overflow problems

//        BiFunction<Integer, Integer, Integer> myAdd = (a, b) -> {return a + b;};
//        System.out.println(myAdd.apply(1, 2));
//        Function<Integer, Integer> addOne = a -> a + 1;
//        System.out.println(addOne.apply(1));

//        String[] array = new String[2];
        String[] array = new String[] {"abc", "cdf"};
        if (array[0] == null) {
            throw new IllegalArgumentException("the value is null");
//            System.out.println("from if code: the value is null");
        } else {
            System.out.println(array[0]);
        }

        Optional opt = Optional.ofNullable(array[0]);
        System.out.println(opt.orElse("From optional: the value is null"));    // print not null case
        opt.orElseThrow(() -> new IllegalArgumentException("the value is null"));    // throw exception
    }

    public static <E> E getFirstElement(E[] array) {
        return array[0];
    }
}

@FunctionalInterface   // optional
interface Drawable{
    public void draw();

    public default void drawCircle(){
        System.out.println("Drawing a circle");
    }

    public default void drawLine(){
        System.out.println("Drawing a line");
    }
}

interface Workout{
    public void deadlift();
}
class Node {
    int key;
    String value;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

class Node2 {
    double key;
    char value;

    public Node2(double key, char value) {
        this.key = key;
        this.value = value;
    }
}

class Node3<K, V> {
    K key;
    V value;

    public Node3(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
