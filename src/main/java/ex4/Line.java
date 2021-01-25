package main.java.ex4;

public class Line extends Shape {
    private Point from;
    private Point to;

    public Line(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Point getCenter() {
        return null;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
