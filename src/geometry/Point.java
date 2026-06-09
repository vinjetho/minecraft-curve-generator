package geometry;

public record Point(double x, double y) {
    
    public Point shifted(double deltaX, double deltaY) {
        return new Point(this.x+deltaX, this.y+deltaY);
    }

}
