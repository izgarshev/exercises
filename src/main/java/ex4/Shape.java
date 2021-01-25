package main.java.ex4;

abstract class Shape {
    private Point point;

    public Shape() {
    }

    public void moveBy(double dx, double dy) {
        point.x = dx;
        point.y = dy;
    }

    public abstract Point getCenter();
}
