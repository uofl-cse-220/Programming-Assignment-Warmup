package shapes;

/** A small demonstration driver, not part of the unit-test requirements. */
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.0, 5.0);
        System.out.println("Rectangle");
        System.out.println("Width: " + rectangle.getWidth());
        System.out.println("Length: " + rectangle.getLength());
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        Circle circle = new Circle(2.0);
        System.out.println("\nCircle");
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Diameter: " + circle.getDiameter());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println("Circumference: " + circle.getCircumference());
    }
}
