package org.example.class6;

import java.beans.BeanProperty;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Class6Notes {
/*
1. Design Pattern
    23 design patterns:
        Creational pattern(pattern that hidden internal implementation):
            ** singleton pattern ** / factory pattern / prototype pattern
        Structure pattern(care about class and object composition):
            decorator pattern / static proxy / dynamic proxy
        Behavior pattern(communications between different modules):
            Observer pattern / interpreter pattern / iterator pattern

    Most Common use pattern:
    Singleton pattern: globally only 1 object in one jvm / classloader
        use case: hardware interface access(avoid access chaos) /
        Logger /
        Configuration file -> many I/O access, we can set up an instance in memory instead of accessing file everytime /
        ThreadPool: one threadPool globally /
        Cache...
    Builder pattern: chain setter method one after one. To avoid redundant code when we set constructor with different
    fields
    Factory pattern: In the Factory pattern, we create objects without exposing the creation logic to the client and
    the client uses the same common interface to create a new type of object.
    Decorator: allows us to dynamically add functionality and behavior to an object without affecting the behavior of
    other existing objects within the same class. We use inheritance to extend the behavior of the class.
    This takes place at compile-time, and all the instances of that class get the extended behavior.
    Observer: The Observer Pattern defines a one(Subject) to many(Observer) dependency between objects so that one
    object changes state, all of its dependents are notified and updated automatically
    static Proxy: client request something to proxy, proxy preprocess the request and send to server.
    server response to proxy, proxy will postprocess the response and send to client
    Dynamic Proxy: 1 to many server / many-to-many relationship proxy with server (using the reflection to fulfill)


2. Reflection - makes Java dynamic
    Reflection is an API that is used to examine or modify the behavior of methods, classes, and interfaces at runtime
    Reflection can access the private class
    Reflection can detect annotations in a method

    How to create an annotation by ourselves?
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface MyAnnotation {
        public String name();
        public String value();
    }

 */

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

//        Department d = Department.builder().setName("Java").setId(1).build();
//        System.out.println(d.toString());

        RunningTestInstance obj = new RunningTestInstance();
        Class cls = obj.getClass();

//        System.out.println("the name of class is: " + cls.getName());
//        Constructor constructor = cls.getConstructor();
//        System.out.println("the constructor is: " + constructor.getName());
//
//        Method[] methods = cls.getMethods(); // get all the method we create and inherited from Object class
//        System.out.println(Arrays.toString(methods));
//        Method[] methods1 = cls.getDeclaredMethods();  // get all the method we declared
//        System.out.println(Arrays.toString(methods1));

        obj.method2(2);  //use object to call method
        Method reflectMethod2 = cls.getDeclaredMethod("method2", int.class);
        reflectMethod2.invoke(obj, 10);  //use reflection to call method, we can modify the code through runtime

        Method reflectMethod3 = cls.getDeclaredMethod("method3");
        reflectMethod3.setAccessible(true);
        reflectMethod3.invoke(obj);

        Class cls2 = RunningTestInstance.class;
        Method reflectMethod4 = cls2.getMethod("method4");
        Annotation[] classAnnotations = reflectMethod4.getDeclaredAnnotations(); // get annotations on method level
        System.out.println(Arrays.toString(classAnnotations));

        Annotation[] annotations = cls2.getAnnotations();  // get the annotation on class level
    }
}

class SingletonObj {
    private static final SingletonObj instance = new SingletonObj();

    private SingletonObj() {

    }
    // eager loading version
    public static SingletonObj getInstance() {
        return instance;
    }

}

class SingletonObjLazy {
    // volatile keyword to prevent instruction reorder
    private static volatile SingletonObjLazy instance;

    private SingletonObjLazy() {

    }
    // lazy loading version
    private static SingletonObjLazy getInstance() {
        // why need synchronized? problem: not thread safe: if 2 threads call getInstance(), will set 2 new instance
        if (instance == null) {
            synchronized (SingletonObjLazy.class) {
                // why check 2 times, ensure other null value thread get in and don't create the new instance again
                if (instance == null) {
                    instance = new SingletonObjLazy();
                    // 1 create instance reference
                    // 2 new singleton()
                    // 3 instance reference to instance object
                    // instruction reorder: sometimes order is 1 -> 2 -> 3(correct), sometimes is 1 -> 3 -> 2(false)
                }
            }
        }
        return instance;
    }
}

class Department {
    private String name;
    private String location;
    private String managerName;
    private int id;

    public Department(String name, String location, String managerName, int id) {
        this.name = name;
        this.location = location;
        this.managerName = managerName;
        this.id = id;
    }

    public static DepartmentBuilder builder() {
        return new DepartmentBuilder();
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", managerName='" + managerName + '\'' +
                ", id=" + id +
                '}';
    }

    public static class DepartmentBuilder{
        private String name;
        private String location;
        private String managerName;
        private int id;

        public DepartmentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DepartmentBuilder setLocation(String location) {
            this.location = location;
            return this;
        }

        public DepartmentBuilder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public DepartmentBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public Department build() {
            Department d = new Department(name, location, managerName, id);
            return d;
        }
    }
}

class RunningTestInstance{
    private String val;

    public RunningTestInstance(){
     this.val = "12345";
    }

    public void method1(){
        System.out.println("the value is: " + this.val);
    }

    public void method2(int n){
        System.out.println("the number is: " + n);
    }

    private void method3() {
        System.out.println("private method");
    }

    @BeanProperty
    @Deprecated
    public void method4(){
        System.out.println("method with annotation");
    }
}
