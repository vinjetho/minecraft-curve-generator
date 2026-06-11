package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersections {
    
    public static List<Point> intersection(Line l, Circle c) {
        //SHAME!!!
        List<Point> result = new ArrayList<>();

        double dx = l.b.x() - l.a.x();
        double dy = l.b.y() - l.a.y();

        double fx = l.a.x() - c.center.x();
        double fy = l.a.y() - c.center.y();

        double a = dx*dx + dy*dy;
        double b = 2 * (fx*dx + fy*dy);
        double k = fx*fx + fy*fy - c.radius*c.radius;

        double discriminant = b*b - 4*a*k;

        if (discriminant < 0) return result; // no intersection

        double sqrtDisc = Math.sqrt(discriminant);
        double t1 = (-b - sqrtDisc) / (2*a);
        double t2 = (-b + sqrtDisc) / (2*a);

        Point p1 = new Point(l.a.x() + t1*dx, l.a.y() + t1*dy);
        Point p2 = new Point(l.a.x() + t2*dx, l.a.y() + t2*dy);
        
        result.add(p1);
        if (discriminant > 0){// only add second point if not tangent
            result.add(p2);
        } 

        return result;


    }

    public static List<Point> intersection(LineSegment l, Circle c){
        List<Point> lineIntersections = intersection((Line) l, c);
        List<Point> segmentIntersections = new ArrayList<>();

        for (Point p : lineIntersections) {
            if (l.pointIsOn(p)) {
                segmentIntersections.add(p);
            }
        }

        return segmentIntersections;
    }

}
