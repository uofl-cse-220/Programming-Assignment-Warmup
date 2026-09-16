package instructor;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shapes.Circle;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@Tag("instructor")
class CircleTest {
    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.125, 0.5, 1.0, 2.0, 2.75, 10.125, 0.000001, 1000000.0})
    void retainsRadiusAndCalculatesEveryMeasurement(double radius) {
        Circle circle = new Circle(radius);
        double area = Math.PI * radius * radius;
        double circumference = 2.0 * Math.PI * radius;
        assertAll(
                () -> assertEquals(radius, circle.getRadius()),
                () -> assertEquals(2.0 * radius, circle.getDiameter()),
                () -> assertEquals(area, circle.getArea(), tolerance(area)),
                () -> assertEquals(circumference, circle.getCircumference(), tolerance(circumference)),
                () -> assertEquals(circumference, circle.getPerimeter(), tolerance(circumference))
        );
    }

    @Test
    void separateCirclesRetainTheirOwnRadii() {
        Circle first = new Circle(0.5);
        Circle second = new Circle(3.0);
        assertAll(
                () -> assertEquals(0.5, first.getRadius()),
                () -> assertEquals(1.0, first.getDiameter()),
                () -> assertEquals(Math.PI * 0.25, first.getArea(), 1e-12),
                () -> assertEquals(Math.PI, first.getPerimeter(), 1e-12),
                () -> assertEquals(Math.PI, first.getCircumference(), 1e-12),
                () -> assertEquals(3.0, second.getRadius()),
                () -> assertEquals(6.0, second.getDiameter()),
                () -> assertEquals(Math.PI * 9.0, second.getArea(), 1e-12),
                () -> assertEquals(Math.PI * 6.0, second.getPerimeter(), 1e-12),
                () -> assertEquals(Math.PI * 6.0, second.getCircumference(), 1e-12)
        );
    }

    @Test
    void gettersDoNotChangeTheCircle() {
        Circle circle = new Circle(2.75);
        for (int attempt = 0; attempt < 5; attempt++) {
            assertEquals(Math.PI * 5.5, circle.getCircumference(), 1e-12);
            assertEquals(Math.PI * 5.5, circle.getPerimeter(), 1e-12);
            assertEquals(Math.PI * 7.5625, circle.getArea(), 1e-12);
            assertEquals(5.5, circle.getDiameter());
            assertEquals(2.75, circle.getRadius());
        }
    }

    @Test
    void storesItsRadiusPrivately() {
        long instanceFields = java.util.Arrays.stream(Circle.class.getDeclaredFields())
                .filter(field -> !field.isSynthetic() && !Modifier.isStatic(field.getModifiers()))
                .peek(field -> assertTrue(Modifier.isPrivate(field.getModifiers()),
                        "Instance fields must be private"))
                .filter(field -> field.getType() == double.class)
                .count();
        assertTrue(instanceFields >= 1, "Store radius in a private double instance field");
    }

    private static double tolerance(double expected) {
        return Math.max(Math.abs(expected) * 1e-12, 1e-24);
    }
}
