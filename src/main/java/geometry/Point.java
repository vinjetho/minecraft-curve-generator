package geometry;

public record Point(double x, double y) {
    
    public static Point origin(){
        return new Point(0,0);
    }

    public Point shifted(double deltaX, double deltaY) {
        return new Point(this.x+deltaX, this.y+deltaY);
    }

    public Point shifted(double delta) {
        return this.shifted(delta, delta);
    }

    public Point add(Point p) {
        return this.shifted(p.x(), p.y());
    }

    public Point subtract(Point p) {
        return this.shifted(-p.x(), -p.y());
    }

    public Point multiply(double factorX, double factorY){
        return new Point(this.x * factorX, this.y * factorY);
    }

    public Point multiply(double factor){
        return this.multiply(factor, factor);
    }

    public Point multiply(Point p) {
        return this.multiply(p.x(), p.y());
    }

    public Point divideBy(double divisorX, double divisorY){
        return new Point(this.x / divisorX, this.y / divisorY);
    }

    public Point divideBy(double divisor) {
        return this.divideBy(divisor, divisor);
    }

    public Point divideBy(Point p) {
        return this.divideBy(p.x(), p.y());
    }

    public double distanceTo(Point p) {
        return Math.sqrt( Math.pow(x-p.x(), 2) + Math.pow(y-p.y(), 2));
    }

    public double vectorMagnitude(){
        return Math.sqrt( Math.pow(x,2) + Math.pow(y,2) );
    }

    public Point unitVector() {
        return this.divideBy(this.vectorMagnitude());
    }

}
