package student;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shapes.Circle;
import shapes.Rectangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("student")
class StudentTest {
    @Test
    void rectangleHasTheExpectedArea() {
        Rectangle rectangle = new Rectangle(3.0, 5.0);
        assertEquals(15.0, rectangle.getArea(), 0.000001);
    }

    @Test
    void circleHasTheExpectedDiameter() {
        Circle circle = new Circle(2.0);
        assertEquals(4.0, circle.getDiameter(), 0.000001);
    }
}
