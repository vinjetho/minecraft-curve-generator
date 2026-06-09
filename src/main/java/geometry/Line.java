package geometry;

public class Line implements Shape{

    public final Point a;
    public final Point b;

    public Line(Point a, Point b) {
        if (!a.equals(b)) {
            this.a = a;
            this.b = b;
        } else {
            throw new IllegalArgumentException("cannot make a line from identical points");
        }
    }

    @Override
    public boolean pointIsOn(Point p) {
        if (a.x() != b.x()) {
            double m = (a.y() - b.y()) / (a.x() - b.x());
            return ( p.y() - a.y() == m * (p.x() - a.x()) );
        } else {
            double m = (a.x() - b.x()) / (a.y() - b.y());
            return ( p.x() - a.x() == m * (p.y() - a.y()) );
        }
    }

    @Override
    public boolean pointIsInside(Point P) {
        return false;
    }

}
