package instructor;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shapes.Rectangle;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@Tag("instructor")
class RectangleTest {
    @ParameterizedTest
    @CsvSource({
            "3.0, 5.0, 15.0, 16.0",
            "5.0, 3.0, 15.0, 16.0",
            "1.0, 1.0, 1.0, 4.0",
            "2.5, 3.25, 8.125, 11.5",
            "0.125, 0.5, 0.0625, 1.25",
            "0.0, 0.0, 0.0, 0.0",
            "0.0, 7.5, 0.0, 15.0",
            "7.5, 0.0, 0.0, 15.0",
            "0.000001, 0.000002, 0.000000000002, 0.000006",
            "1000000.0, 2000000.0, 2000000000000.0, 6000000.0"
    })
    void retainsDimensionsAndCalculatesAreaAndPerimeter(
            double width, double length, double area, double perimeter) {
        Rectangle rectangle = new Rectangle(width, length);
        assertAll(
                () -> assertEquals(width, rectangle.getWidth()),
                () -> assertEquals(length, rectangle.getLength()),
                () -> assertEquals(area, rectangle.getArea(), tolerance(area)),
                () -> assertEquals(perimeter, rectangle.getPerimeter(), tolerance(perimeter))
        );
    }

    @Test
    void separateRectanglesRetainTheirOwnDimensions() {
        Rectangle first = new Rectangle(2.5, 7.0);
        Rectangle second = new Rectangle(11.0, 4.25);
        assertAll(
                () -> assertEquals(2.5, first.getWidth()),
                () -> assertEquals(7.0, first.getLength()),
                () -> assertEquals(17.5, first.getArea()),
                () -> assertEquals(19.0, first.getPerimeter()),
                () -> assertEquals(11.0, second.getWidth()),
                () -> assertEquals(4.25, second.getLength()),
                () -> assertEquals(46.75, second.getArea()),
                () -> assertEquals(30.5, second.getPerimeter())
        );
    }

    @Test
    void gettersDoNotChangeTheRectangle() {
        Rectangle rectangle = new Rectangle(2.5, 7.0);
        for (int attempt = 0; attempt < 5; attempt++) {
            assertEquals(19.0, rectangle.getPerimeter());
            assertEquals(17.5, rectangle.getArea());
            assertEquals(7.0, rectangle.getLength());
            assertEquals(2.5, rectangle.getWidth());
        }
    }

    @Test
    void storesItsDimensionsPrivately() {
        long instanceFields = java.util.Arrays.stream(Rectangle.class.getDeclaredFields())
                .filter(field -> !field.isSynthetic() && !Modifier.isStatic(field.getModifiers()))
                .peek(field -> assertTrue(Modifier.isPrivate(field.getModifiers()),
                        "Instance fields must be private"))
                .filter(field -> field.getType() == double.class)
                .count();
        assertTrue(instanceFields >= 2, "Store width and length in private double instance fields");
    }

    private static double tolerance(double expected) {
        return Math.max(Math.abs(expected) * 1e-12, 1e-24);
    }
}
