package org.example.class2;

class OuterClass{

    private static String msg="Hello from OuterClass";

    public static class NestedStaticClass{
        // Only static members of Outer class
        // is directly accessible in nested
        // static class

        public void printMessage() {
            System.out.println("Hello from Nested static class: " + msg);
        }
    }

    public class InnerClass{
        public void displayMessage(){
            System.out.println("Hello from InnerClass: " + msg);
        }
    }
}

class Test {

    public static void main(String[] args) {
        OuterClass.NestedStaticClass nested = new OuterClass.NestedStaticClass();
        nested.printMessage();

        // Note: In order to create instance of Inner class
        //  we need an Outer class instance
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.displayMessage();

        // We can also combine above steps in one
        // step to create instance of Inner class
        OuterClass.InnerClass innerObject
                = new OuterClass().new InnerClass();

        // Similarly calling inner class defined method
        innerObject.displayMessage();
    }
}