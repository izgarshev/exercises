package main.java.ex4;

/**
 * 1. Define a class Point with a constructor public Point(double x,
 * double y) and accessor methods getX, getY. Define a subclass
 * LabeledPoint with a constructor public LabeledPoint(String
 * label, double x, double y) and an accessor method getLabel.
 * 2. Define toString, equals, and hashCode methods for the classes of the
 * preceding exercise.
 * 3. Make the instance variables x and y of the Point class in Exercise 1
 * protected. Show that the LabeledPoint class can access these variables
 * only in LabeledPoint instances.
 * 4. Define an abstract class Shape with an instance variable of class Point, a
 * constructor, a concrete method public void moveBy(double dx,
 * double dy) that moves the point by the given amount, and an abstract method
 * public Point getCenter(). Provide concrete subclasses Circle,
 * Rectangle, Line with constructors public Circle(Point center,
 * double radius), public Rectangle(Point topLeft, double
 * width, double height), and public Line(Point from, Point
 * to).
 * 5. Define clone methods for the classes of the preceding exercise.
 * 6. Suppose that in Section 4.2.2, “The equals Method” (page 148), the
 * Item.equals method uses an instanceof test. Implement
 * DiscountedItem.equals so that it compares only the superclass if
 * otherObject is an Item, but also includes the discount if it is a
 * DiscountedItem. Show that this method preserves symmetry but fails to be
 * transitive—that is, find a combination of items and discounted items so that
 * x.equals(y) and y.equals(z), but not x.equals(z).
 * 7. Define an enumeration type for the eight combinations of primary colors BLACK,
 * RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE with methods getRed,
 * getGreen, and getBlue
 */
public class Main {

    public static void main(String[] args) {

    }
}
