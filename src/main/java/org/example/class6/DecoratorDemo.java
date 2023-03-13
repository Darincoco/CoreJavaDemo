package org.example.class6;

public class DecoratorDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(circle);
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle with red border");
        redCircle.draw();

        System.out.println("\nRectangle with red border");
        redRectangle.draw();
    }
}

interface Shape{
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw(){
        System.out.println("shape: circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("shape: rectangle");
    }
}

abstract class ShapeDecorator implements Shape {
    protected Shape decoratorShape;

    public ShapeDecorator (Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }
    @Override
    public void draw(){
        decoratorShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }
    @Override
    public void draw() {
        decoratorShape.draw();
        setRedBorder(decoratorShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("border color: red");
    }

}