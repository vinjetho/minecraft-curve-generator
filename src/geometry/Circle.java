package geometry;

public class Circle implements Shape {

    public final Point center;
    public final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean pointIsOn(Point p) {
        return Math.pow((p.x()-center.x()), 2) + Math.pow((p.y()-center.y()), 2) == Math.pow(radius,2);
    }

    @Override
    public boolean pointIsInside(Point p) {
        return Math.pow((p.x()-center.x()), 2) + Math.pow((p.y()-center.y()), 2) < Math.pow(radius,2);
    }
    
}
