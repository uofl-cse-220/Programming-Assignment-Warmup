# CSE 220 — Programming Warmup: Shapes

## Project manager statement

> As a project manager, I need two simple Java classes that calculate the
> dimensions, area and perimeter of rectangles and circles so our application
> can use these calculations consistently.

## File layout

```text
repository root/
├── README.md
├── .github/
│   ├── actions/instructor/
│   │   ├── action.yml
│   │   └── auto-grading-config.json
│   └── workflows/
│       └── auto-grading-workflow.yml
└── Assignment/
    ├── pom.xml
    └── src/
        ├── main/java/shapes/
        │   ├── Main.java              provided driver
        │   ├── Rectangle.java         create this file
        │   └── Circle.java            create this file
        └── test/java/
            ├── student/
            │   └── StudentTest.java
            └── instructor/
                ├── RectangleTest.java
                └── CircleTest.java
```

Create `Rectangle.java` and `Circle.java` in the `shapes` package, using the exact
names and capitalization above. These classes are not provided in the starter.
The project will not compile until you add the required classes and methods.

Use Java 24 and Maven. Open `Assignment/pom.xml` in IntelliJ.
`Main.java` demonstrates your classes and has no dedicated unit tests.

Do not modify any file under `Assignment/src/test/java/instructor/`.
You may add or change tests under `Assignment/src/test/java/student/`.

## Class components

Create public classes with public constructors and methods. Store each object's
dimensions in private instance fields. Every getter below returns a `double`.
Assume dimensions are finite and nonnegative, including zero. Input validation
and exception handling are not required. Do not round calculated results.

### Rectangle — shapes.Rectangle

Constructor: `Rectangle(double width, double length)`, in that order.

| Method | Returns |
| --- | --- |
| `getWidth()` | The supplied width |
| `getLength()` | The supplied length |
| `getArea()` | Width × length |
| `getPerimeter()` | 2 × (width + length) |

### Circle — shapes.Circle

Constructor: `Circle(double radius)`.

| Method | Returns |
| --- | --- |
| `getRadius()` | The supplied radius |
| `getDiameter()` | 2 × radius |
| `getArea()` | π × radius × radius |
| `getCircumference()` | 2 × π × radius |
| `getPerimeter()` | The circumference |

Use `Math.PI` for π. Each object must retain its own dimensions, and calling a
getter must not change them.

## How grading works

Run `mvn test` from `Assignment` to run both test groups.
Run `mvn compile exec:java` there to try the provided driver.

Push your changes to run **Auto grading** and receive a Grade Token.

| Result | Grade |
| --- | --- |
| Build succeeds and all tests pass | **100 points** |
| Any test fails or errors, the build fails, or no tests are found | **10 points** |

There are no intermediate scores or first-commit bonuses. Setup errors,
cancellation or timeouts may prevent a token from being issued.
A green workflow does not guarantee 100 points. Check the score in the run summary.

## How to submit your grade

In the GitHub run summary, use the **copy-to-clipboard button** in the
**Grade Token** section to copy the entire text string beginning with `ACGT1_`.

Blackboard provides a text field. Paste **only the complete token for the grade
you want submitted**.

**Only one submission is allowed.** Choose the correct token before submitting.
