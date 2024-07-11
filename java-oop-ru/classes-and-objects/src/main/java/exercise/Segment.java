package exercise;

// BEGIN
public class Segment {
    private final Point beginPoint;
    private final Point endPoint;

    public Segment(Point firstPoint, Point secondPoint) {
        this.beginPoint = firstPoint;
        this.endPoint = secondPoint;
    }

    public Point getMidPoint() {
        int xAverage = (beginPoint.getX() + endPoint.getX()) / 2;
        int yAverage = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(xAverage, yAverage);
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
}
// END
