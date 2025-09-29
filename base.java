// Write a Java program to implement hierarchical inheritance. Create a 
// base class Shape with a method area(). Derive two classes, Circle
// and Rectangle, from Shape. Override the area() method in both 
// subclasses to calculate and display the area of a circle and a rectangle, 
// respectively. Use appropriate constructors to initialize the attributes 
// (radius for the circle, length, and width for the rectangle).
class Shape {
    public void area() {
        System.out.println("Calculating area of a generic shape.");
    }
}
class Circle extends Shape { 
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public void area() {
        double circleArea = Math.PI * radius * radius;
        System.out.println("Area  of circle" + radius + " is: " + circleArea);
    }
}
class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public void area() {
        double rectangleArea = length * width;
        System.out.println("Area of Rectangle with length " + length + " and width " + width + " is: " + rectangleArea);
    }
}
public class base {
    public static void main(String[] args) {
        Circle myCircle = new Circle(5.0);
        myCircle.area(); 
        Rectangle myRectangle = new Rectangle(4.0, 6.0);
        myRectangle.area();
        Shape genericShape = new Shape();
        genericShape.area(); 
    }
}