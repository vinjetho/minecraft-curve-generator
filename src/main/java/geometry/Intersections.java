package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersections {
    
    public static List<Point> intersection(LineSegment l, Circle c) {
        //throw new UnsupportedOperationException("Unimplemented method 'intersection'");
        
        /*
        
        p = l.a + t*(b-a)
        |p - center|^2 = radius^2

        At^2 + Bt + C = 0
        d = b-a
        f = a-center
        A = d.x^2 + d.y^2
        B = 2 * (f.x*d.x + f.y*d.y)
        C = 
        */

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

        result.add(new Point(l.a.x() + t1*dx, l.a.y() + t1*dy));

        Point n = new Point(l.a.x() + t2*dx, l.a.y() + t2*dy);
        if (discriminant > 0 && l.pointIsOn(n)) // only add second point if not tangent
            result.add(n);

        return result;


    }

}
