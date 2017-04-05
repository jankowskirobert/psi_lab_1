
import java.util.*;

public class Tour {
	private Node tour;
	private int size;

	Tour() {
		size = 0;
	}

	public Tour(Point a, Point b, Point c, Point d) {
		size = 4;
		tour = new Node(a);
		tour.insert(b, 1);
		tour.insert(c, 2);
		tour.insert(d, 3);
	}

	void show()
	{
		for (int i = 0; i < size; i++) {
			System.out.print(tour.get(i).getPoint() + "[");
			System.out.print(tour.get(i).getPoint().getDistanceToLastMeasure()+"]");
			System.out.print("{"+tour.get(i).getPoint().getLastDistanceMeasurePoint()+"}\n");
		}
	}

	int size() {
		return size;
	}

	double distance()// return the total distance of the tour
	{
		double distance = 0;

		for (int i = 1; i < size; i++) {
			distance += tour.get(i).getPoint().distanceTo(tour.get(i - 1).getPoint());
		}

		distance += tour.get(0).getPoint().distanceTo(tour.get(size - 1).getPoint());
		return distance;
	}

	void insertNeighbour(Point p)
	{
		if (size == 0) {
			size = 1;
			tour = new Node(p);
			return;
		}

		double dist = Double.POSITIVE_INFINITY;
		int nearest = 0;

		for (int i = 0; i < size; i++) {
			if (tour.get(i).getPoint().distanceTo(p) < dist) {
				dist = tour.get(i).getPoint().distanceTo(p);
				nearest = i;
			}
		}
		tour.insert(p, nearest);
		size++;
	}

	void shortestDistanceBetween(int pointsToVisit, int nodePosition){
		double distancesBetweenPoints[][] = new double[pointsToVisit][pointsToVisit];
		if(size>= pointsToVisit){
			
		} else {
			for(int i = nodePosition; i < size ; i++){
				
			}
		}
	}
	
	void insertShortDistance(Point p)
	{
		if (size == 0) {
			size = 1;
			tour = new Node(p);
			return;
		}

		double smallestIncrease = Double.POSITIVE_INFINITY;
		int index = 0;
		double originalD, newD;
		for (int i = 1; i < size; i++) {
			originalD = tour.get(i).getPoint().distanceTo(tour.get(i - 1).getPoint());

			newD = p.distanceTo(tour.get(i).getPoint()) + p.distanceTo(tour.get(i - 1).getPoint());// distance

			if (newD - originalD <= smallestIncrease) {
				smallestIncrease = newD - originalD;
				index = i - 1;
			}
		}
		originalD = tour.get(0).getPoint().distanceTo(tour.get(size - 1).getPoint());// distance

		newD = p.distanceTo(tour.get(0).getPoint()) + p.distanceTo(tour.get(size - 1).getPoint());// distance

		if (newD - originalD <= smallestIncrease) {
			smallestIncrease = newD - originalD;
			index = size - 1;
		}

		tour.insert(p, index);
		size++;
	}

	private class Node {
		private Point p;
		private Node next;// this would all be so much easier if I could use C++

		public Node(Point p) {
			this.p = p;
			next = null;
		}

		public Node(Point p, Node n) {
			this.p = p;
			next = n;
		}

		public void insert(Point point, int i) {
			i--;
			if (i >= 0) {
				next.insert(point, i); // Yo dawg, I heard you like insert
										// methods...
			} else {
				Node n = next;
				next = new Node(point, n);
			}
		}

		public Point getPoint() {
			return p;
		}

		public Node get(int index) {
			index--;
			if (index >= 0) {
				return next.get(index);
			} // recursive recursion

			return this;
		}
	}
}
