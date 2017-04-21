package problem;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.IntStream;

import point.Point;
import strategy.FindNearbly;
import strategy.HeuresticStrategy;

public class Journey {
	private LinkedList<Point> listOfPoints = new LinkedList<Point>();
	private HeuresticStrategy strategy = new FindNearbly();

	public void heuresticNearest(Point p) {
		if (!listOfPoints.isEmpty()) {
			double closest = Double.MAX_VALUE;
			int pos = 0;
			for (int i = 0; i < listOfPoints.size(); i++) {
				if (listOfPoints.get(i) != null) {
					double dist = listOfPoints.get(i).distance(p);
					if (dist < closest) {
						pos = i;
						closest = dist;
					}
				}
			}
			listOfPoints.add(pos, p);
		} else {
			listOfPoints.add(p);
		}
	}

	private double[][] prepareNearblyMatrix(LinkedList<Point> points) {
		double w[][] = new double[points.size()][points.size()];
		for (int x = 0; x < points.size(); x++) {
			for (int y = 0; y < points.size(); y++) {
				if (x == y) {
					w[x][y] = Double.POSITIVE_INFINITY;
				} else {
					w[x][y] = strategy.getResult(new Point[] { points.get(x), points.get(y) });// .distance(points.get(y));
				}
			}
		}
		for (double[] tmpY : w) {
			for (double tmpX : tmpY) {
				System.out.print(String.format("%-10f ", tmpX));
			}
			System.out.println();
		}
		System.out.println();
		return w;
	}

	private double[][] reduceMatrix(double[][] matrix){
		double[][] output = new double[matrix.length][matrix.length];
		double reducedValue = 0;
		for(int n = 0 ; n < matrix.length ; n++){
			double minRow = Double.MAX_VALUE;
			for(int m = 0; m < matrix[n].length ; m++){
				if(matrix[n][m] < minRow)
					minRow = matrix[n][m]; 
			}
			for(int m = 0; m < matrix[n].length ; m++){
				output[n][m] = matrix[n][m] - minRow;
				
 			}
			reducedValue += minRow;
			
		}
		
		for(int n = 0 ; n < matrix.length ; n++){
			double minCol = Double.MAX_VALUE;
			for(int m = 0; m < matrix.length ; m++){
				if(matrix[m][n] < minCol)
					minCol = matrix[m][n]; 
			}
			for(int m = 0; m < matrix.length ; m++){
				output[m][n] = matrix[m][n] - minCol;
				
 			}
			reducedValue += minCol;
			
		}
		
		//print
		for (double[] tmpY : output) {
			for (double tmpX : tmpY) {
				System.out.print(String.format("%-10f ", tmpX));
			}
			System.out.println();
		}
		System.out.println("Sum min row: "+reducedValue);
		return output;
	}
	
	public void heuresticNearest(LinkedList<Point> p) {
		// double cost[][] = new
		// double[listOfPoints.size()][listOfPoints.size()];
		reduceMatrix(prepareNearblyMatrix(p));
		for (Point tmp : p) {
			heuresticNearest(tmp);
		}
	}

	public void print() {
		for (int i = listOfPoints.size() - 1; i > 0; i--) {
			if (i < listOfPoints.size() - 1) {
				System.out.println(listOfPoints.get(i) + " " + listOfPoints.get(i).distanceTo(listOfPoints.get(i - 1)));
			} else
				System.out.println(listOfPoints.get(i));
		}
	}

	public double distance() {
		double dist = 0;
		for (int i = 0; i < listOfPoints.size() - 1; i++) {
			dist += listOfPoints.get(i).distance(listOfPoints.get(i + 1));
		}
		return dist;
	}

	public static void main(String[] args) {
		System.out.println("HEURE:");
		Journey j = new Journey();
		LinkedList<Point> listOfPoints = new LinkedList<>();
		listOfPoints.add(new Point(10, 10));
		listOfPoints.add(new Point(5, 16));
		listOfPoints.add(new Point(12, 17));
		listOfPoints.add(new Point(10, 16));
		listOfPoints.add(new Point(11, 10));
		listOfPoints.add(new Point(9, 1));
		listOfPoints.add(new Point(12, 17));
		listOfPoints.add(new Point(1, 14));
		listOfPoints.add(new Point(10, 11));
		j.heuresticNearest(listOfPoints);
		double dist = 0;
		for (int i = 0; i < listOfPoints.size() - 1; i++) {
			dist += listOfPoints.get(i).distance(listOfPoints.get(i + 1));
		}
		System.out.println("INPUT: " + dist);
		System.out.println("OUTPUT: " + j.distance());
		j.print();
	}
}
