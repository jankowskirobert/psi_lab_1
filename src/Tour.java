
import java.util.*;

public class Tour {
	private Node tour;
	private int size;// I could use the Node class to calculate distance... but
						// that would take time

	Tour()// empty tour
	{
		size = 0;
	}

	Tour(Point a, Point b, Point c, Point d)// create a 4 point tour
											// a->b->c->d->a
	{
		size = 4;
		tour = new Node(a);
		tour.insert(b, 1);
		tour.insert(c, 2);
		tour.insert(d, 3);
	}

	void show()// print the tour to standard output
	{
		for (int i = 0; i < size; i++) {
			StdOut.print(tour.get(i).getPoint());
		}
	}

	void draw()// draw the tour to standard draw
	{
		tour.get(0).getPoint().draw();
		for (int i = 1; i < size; i++) {
			tour.get(i).getPoint().draw();
			tour.get(i).getPoint().drawTo(tour.get(i - 1).getPoint());
		}
		tour.get(0).getPoint().drawTo(tour.get(size - 1).getPoint());
	}

	int size() {
		return size;
	}// number of points on tour

	double distance()// return the total distance of the tour
	{
		double distance = 0;

		for (int i = 1; i < size; i++) {
			distance += tour.get(i).getPoint().distanceTo(tour.get(i - 1).getPoint());
		}

		distance += tour.get(0).getPoint().distanceTo(tour.get(size - 1).getPoint());
		return distance;
	}

	void insertNearest(Point p)// insert p using nearest neighbour heuristic
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
				dist = tour.get(i).getPoint().distanceTo(p);// pretty simple,
															// keep track of
															// smallest distance
				nearest = i;// and the point that gave that distance
			}
		}

		tour.insert(p, nearest);// then add that point

		size++;
	}

	void insertSmallest(Point p)// insert p using smallest increase heuristic
	{
		if (size == 0) {
			size = 1;
			tour = new Node(p);
			return;
		}

		double smallestIncrease = Double.POSITIVE_INFINITY;
		int index = 0;// handle the second point
		double originalD, newD;// HAHAHAHAHAHA... "newd" XD
		for (int i = 1; i < size; i++) {
			originalD = tour.get(i).getPoint().distanceTo(tour.get(i - 1).getPoint());// distance
																						// from
																						// A
																						// to
																						// B
			newD = p.distanceTo(tour.get(i).getPoint()) + p.distanceTo(tour.get(i - 1).getPoint());// distance
																									// from
																									// A
																									// to
																									// P
																									// to
																									// B
			if (newD - originalD <= smallestIncrease) {
				smallestIncrease = newD - originalD;
				index = i - 1;
			}
		}
		originalD = tour.get(0).getPoint().distanceTo(tour.get(size - 1).getPoint());// distance
																						// from
																						// first
																						// to
																						// last
		newD = p.distanceTo(tour.get(0).getPoint()) + p.distanceTo(tour.get(size - 1).getPoint());// distance
																									// from
																									// first
																									// to
																									// P
																									// to
																									// last
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
/*
 * On a final note: The Java notation makes me very uncomfortable for some
 * reason, hence the C style curly brackets
 */