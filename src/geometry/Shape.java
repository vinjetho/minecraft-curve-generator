package geometry;

public interface Shape {
    
    public boolean pointIsOn(Point p);

    public boolean pointIsInside(Point p);

    public default boolean pointIsOutside(Point p) {
        return !this.pointIsOn(p) && !this.pointIsInside(p);
    }
}
