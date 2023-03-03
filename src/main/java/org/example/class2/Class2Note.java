package org.example.class2;

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.List;

public class Class2Note {
/*
1. Java, compile once, run on any platform(JVM)
    .java file -> .class file(byteCode) -> machine code


2. JVM Architecture
    Class loader
        Bootstrap class loader: like java.lang.*, java.util.*
        Extension class loader: $JAVA_HOME/jre/lib/ext(ODBC/ JDBC driver), subclass of Bootstrap class loader
        Application class loader: load files present on the classPath we create, subclass of Extension class loader

        parents delegation mode:
        request: application class loader -> extension class loader -> bootstrap class loader
        result: bootstrap class loader -> extension class loader -> application class loader

    Run time data area
        Method area: store all class level data, run-time constant pool, field. and method data...
        Heap area: new keyword to create object, this object will in heap area
        Stack area: Stack frame AKA call stack(info of method call)
        PC Register: multiple threads, pc register -> jvm instruction
        Native Stack area: method written in other language

    Execution engine
        Interpreter: to interpret class file to machine code, line by line
        Just-In-Time (JIT) compiler: monitor code, if code repeated many times(hotspot), reorganize code to optimize it
        GC: don't do it manually.
            phrases: mark(find out which object is inactive), sweep(clean object), (compact)(put active object together)
            types: serial GC: one thread do GC -> "stop the world"
                   parallel GC(default GC): multiple thread do GC
                   G1 GC(big memory space >= 4GB): chunks
                          eden region, survivor region, tenured region, humongous region, available region
                   CMS: deprecated at java 9, removed at java 14, G1GC replaced it
        Java Native method Interface (JNI): a bridge to connect other language(Native method library) to java code


3. reserved word(53)
    keywords(50):
        used keywords(48):
            reserved words for data types(8): byte, short, int, long, float, double, char, boolean
            flow control(11): if, else, switch, case, default, for, do, while, break, continue, return
            modifiers(11): public(access anywhere), private(access in class), protected(class and child),
                       static, final, abstract, synchronized, native, strictfp, transient, volatile,
            exception handling(6): try, catch, finally, throw, throws, assert
            class(6): class, package, import, extends, implements, interface
            object(4): new, instanceof, super, this
            not listed(2): enum, void

        unused keywords(2): goto/ const
    reserved literals(3):
        true/false/null

    final:
        final variable: can't modify it(actually limit reassign), need initialization
            *static modifier is the only one have default value without initialization because Init in Class Loader
        final method: can not be overridden
        final class: can not be inherited
        how to create an immutable class:
        - create a final class so can not extend
        - private keyword to restrict access to the parameters in class
        - don't provide set method so can not change value
        - deep copy of collection(constructor and get method)
          Why?  In example values have List<Integer>, final only restrict the reassignment, we need to return a deepCopy
                of List so that change on the list of get method will not affect our original value constructor set.
        final, finally, finalize:
            final: a keyword used to define variable, method, class
            finally: a keyword in a try catch block, method in finally will always execute
            finalize: not a key word, a method will be invoked before GC

    static:
        static blocks: will run once when JVM starts, to initialize all variables
        static variable: will do initialization, can be accessed from other class without setting an object
        static method: can be accessed from other class without setting an object /
                       non-static method can access static method, static method can't access non-static method
                       when static method access non-static, need to set up an object and call method in this object
        static classes: nested class in a class, like Map.Entry<Integer, Integer>

    Implements and extends:
        extends: to extend a class, but one class one time(single inheritance)
        implements: to extend a class, but many classes one time


4. OOP:
    abstraction:
        abstract class: can have concrete method to be implemented, can have abstract method
                        can have final/non-final, static/ non-static
        interface: only have abstract method, only have final, static variable, define usage of a class

    encapsulation: declare variable as private, getter and setter, to hide the internal implementation

    inheritance: extends, implements class/ inheritance will check recursively
                 class A has a method, class B extends A and has an override method, class C extends B but no method
                 A obj = new C();
                 obj.method;   -> call B
                 B obj = new C();
                 obj.method;   -> call B
                 A obj = new A();
                 obj.method;   -> call A
                 class A has a static method, class B extends A, has static method, class C extends B but no method
                 A obj = new C();
                 obj.method;   -> call A
                 B obj = new C();
                 obj.method;   -> call B
                 A obj = new A();
                 obj.method;   -> call A

    polymorphism: overload(same method with different types variables) compile time polymorphism
                  override(same method with same variables, different implementation) runtime time polymorphism
                  a static method can never be overridden

 */
    public static void methodForStatic() {
        System.out.println("hello from methodForStatic");
    }

    public void methodForNonStaic() {
        System.out.println("hello from methodForNonStaic");
    }

    public static void main(String[] args) {
//        MyImmutableClass test = new MyImmutableClass(1,new ArrayList<>());
//        List<Integer>testList = test.getList();
//        testList.add(1);
//        testList.add(2);
//        testList.add(3);
//
//        System.out.println("testList is: " + testList);
//        System.out.println("List in class is:" + test.getList());

        methodForStatic();
        Class2Note obj = new Class2Note();
        obj.methodForNonStaic();
    }
}

final class MyImmutableClass {

    private final int id;
    private final List<Integer> list;

    MyImmutableClass(int id, List<Integer> list) {
        this.id = id;
        this.list = deepCopy(list);
    }

    public int getId() {
        return id;
    }

    public List<Integer> getList() {
        return deepCopy(this.list);
    }

    private List<Integer> deepCopy(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer ele: list) {
            newList.add(ele);
        }
        return newList;
    }
}
