package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import geometry.*;
import grid.*;
import swag.BlockType;

public class IntersectionAlgorithm implements ICircleAlgorithm {

    @Override
    public IGrid<BlockType> getGrid(int diameter) {
        
        IGrid<BlockType> grid = new Grid(diameter, diameter);

        float r = (diameter-1)/2f;
        Circle circle = new Circle(new Point(r,r), r);
        
        for (GridCell<BlockType> cell : grid) {
            
            Point c = new Point(cell.pos().col(), cell.pos().row());

            //TODO: make square/rectangle class that can give you its corners and sides
            Point nw = c.shifted(-0.5,-0.5);
            Point ne = c.shifted( 0.5,-0.5);
            Point se = c.shifted( 0.5, 0.5);
            Point sw = c.shifted(-0.5, 0.5);

            LineSegment n = new LineSegment(nw,ne);
            LineSegment e = new LineSegment(ne,se);
            LineSegment w = new LineSegment(nw,sw);
            LineSegment s = new LineSegment(sw,se);

            List<Point> intersects = new ArrayList<>();
            intersects.addAll(Intersections.intersection(n, circle));
            intersects.addAll(Intersections.intersection(e, circle));
            intersects.addAll(Intersections.intersection(w, circle));
            intersects.addAll(Intersections.intersection(s, circle));

            intersects = removeDupes(intersects);

            if (intersects.size() > 0) {
                grid.set(cell.pos(), findFittingBlock(nw, ne, se, sw, intersects));
            }

        }
        

        return grid;

    }


    private BlockType findFittingBlock(Point nw, Point ne, Point se, Point sw, List<Point> intersects) {
        
        //CRAZY LOGIC GOES IN HERE

        if (intersects.size() == 2){
            Point i1 = intersects.get(0);
            Point i2 = intersects.get(1);
            LineSegment intersectLine = new LineSegment(i1, i2);
            
            if (i1.y() == i2.y()) {
                return BlockType.ERROR;
            }

            double slope = Math.abs((i1.x() - i2.x()) / (i1.y() - i2.y()));
            System.out.println(slope);
            double dist  = nw.lerpTo(se, 0.5).subtract(intersectLine.midPoint()).vectorMagnitude();

            //
            if (0.5 <= slope && slope <= 2 && dist <= 0.35) {
                return BlockType.STAIR;
            }

            return BlockType.AIR;
            

        } else {
            return BlockType.ERROR;
        }
        
    }
    
    private <T> List<T> removeDupes(List<T> oldList){
        ArrayList<T> newList = new ArrayList<>();

        for (T item : oldList){
            if (!newList.contains(item)) {
                newList.add(item);
            }
        }

        return newList;
    }


    @Override
    public String toString() {
        return "line circle intersections";
    }
    
}
