package point;

public class Point extends java.awt.Point implements Comparable<Point> {
	
	private Point lastDistanceMeasurePoint = null;
	private double distanceToLastMeasure = 0;
	
	
	public Point(int i, int j) {
		super(i,j);
	}

	public int distanceTo(Point city) {
		lastDistanceMeasurePoint = city; 
        double x = Math.abs(getX() - city.getX());
        double y = Math.abs(getY() - city.getY());
        distanceToLastMeasure = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        
        return (int)distanceToLastMeasure;
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

	@Override
	public int compareTo(Point o) {
		int distF = this.distanceTo(o);
		System.out.println("Measure: " + distF + " from: " +this + " to: "+ o);
		return Integer.compare((int)this.distance(o), (int)o.distance(this));// ;
	}

}
