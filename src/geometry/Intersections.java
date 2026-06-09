package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersections {
    
    public static List<Point> intersection(LineSegment L, Circle C) {
        //throw new UnsupportedOperationException("Unimplemented method 'intersection'");
        System.out.println("i got this far!");
        return new ArrayList<Point>(Arrays.asList(

            new Point(0,0),
            new Point(0,1),
            new Point(2,1)
        )
        );
    }

}
