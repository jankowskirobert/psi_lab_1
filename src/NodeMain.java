
public class NodeMain {
public static void main(String[] args) {
	Tour tour = new Tour();
	tour.insertNeighbour(new Point(5, 2));
	tour.insertNeighbour(new Point(1, 2));
	tour.insertNeighbour(new Point(21, 2));
	tour.insertNeighbour(new Point(5, 72));
	tour.insertNeighbour(new Point(21, 22));
	tour.show();
	System.out.println(tour.distance());
}
}
