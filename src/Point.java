
public class Point extends java.awt.Point {
	
	private Point lastDistanceMeasurePoint = null;
	private double distanceToLastMeasure = 0;
	
	
	public Point(int i, int j) {
		super(i,j);
	}

	public double distanceTo(Point city) {
		lastDistanceMeasurePoint = city; 
        double x = Math.abs(getX() - city.getX());
        double y = Math.abs(getY() - city.getY());
        distanceToLastMeasure = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distanceToLastMeasure;
    }

	public Point getLastDistanceMeasurePoint() {
		return lastDistanceMeasurePoint;
	}

	public void setLastDistanceMeasurePoint(Point lastDistanceMeasurePoint) {
		this.lastDistanceMeasurePoint = lastDistanceMeasurePoint;
	}

	public double getDistanceToLastMeasure() {
		return distanceToLastMeasure;
	}

	public void setDistanceToLastMeasure(double distanceToLastMeasure) {
		this.distanceToLastMeasure = distanceToLastMeasure;
	}

}
