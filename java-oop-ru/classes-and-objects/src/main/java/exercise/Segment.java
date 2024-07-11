package exercise;

// BEGIN
public class Segment {
    private final Point firstPoint;
    private final Point secondPoint;

    public Segment(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point getMidPoint() {
        int xAverage = (firstPoint.getX() + secondPoint.getX()) / 2;
        int yAverage = (firstPoint.getY() + secondPoint.getY()) / 2;
        return new Point(xAverage, yAverage);
    }
}
// END
