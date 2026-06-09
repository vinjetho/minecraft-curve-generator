package geometry;

public class LineSegment extends Line {

    public LineSegment(Point a, Point b) {
        super(a, b);
    }
    
    @Override
    public boolean pointIsOn(Point p) {
        //add check if the point is between the defining point of the segment
        return (
            ( Math.min(a.x(), b.x()) <= p.x() && p.x() <= Math.max(b.x(), a.x()) ) &&
            ( Math.min(a.y(), b.y()) <= p.y() && p.y() <= Math.max(b.y(), a.y()) ) &&
            super.pointIsOn(p) 
        );
    }
}
