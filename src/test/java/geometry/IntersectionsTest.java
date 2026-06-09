package geometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class IntersectionsTest {

    @Test
    void circleLineIntersectionTest(){
        
        Circle c = new Circle(new Point(2,2), 3);
        

        //test tangent
        Point a = new Point(0,5);
        Point b = new Point(5,5);
        LineSegment l = new LineSegment(a,b);

        List<Point> intersections = Intersections.intersection(l,c);

        assertTrue(intersections.size() > 0);
        assertEquals(intersections.size(), 1);
        assertEquals(intersections.get(0), new Point(2,5));

        //test not tangent
        a = new Point(0,5);
        b = new Point(2,4);
        l = new LineSegment(a,b);

        intersections = Intersections.intersection(l,c);

        assertTrue(intersections.size() > 0);
        assertEquals(intersections.size(), 1);
        assertEquals(intersections.get(0), new Point(0.6459340771462, 4.6770329614269));

    }
}
