package algorithms;

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


            Point nw = c.shifted(-0.5, 0.5);
            Point ne = c.shifted( 0.5, 0.5);
            Point se = c.shifted( 0.5,-0.5);
            Point sw = c.shifted(-0.5,-0.5);

            LineSegment n = new LineSegment(nw,ne);
            LineSegment e = new LineSegment(ne,se);
            LineSegment w = new LineSegment(nw,sw);
            LineSegment s = new LineSegment(sw,se);

            if (Intersections.intersection(s, circle).size() > 0){
                grid.set(cell.pos(), BlockType.BLOCK);
            }

        }
        

        return grid;

    }

    private Point cellPosToCoord(int row, int col, int diameter) {
        return new Point(
            col - (diameter-1)/2f,
            (diameter-1)/2f - row
        );
    }

    


    @Override
    public String toString() {
        return "line circle intersections";
    }
    
}
