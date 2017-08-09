package com.travelproblem.LAB_1;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void addNodeToTourShouldReturnListOfNodes() {
		CityNode nodeFirst = new CityNode(100, 300);
		CityNode nodeSecond = new CityNode(10, 310);
		CityNode nodeThird = new CityNode(300, 10);
		CityNode nodeFourth = new CityNode(400, 90);
		CityNode nodeFifth = new CityNode(30, 90);
		Tour tour = new Tour();
		TourResult tourResult = tour
				.to(nodeFirst)
				.to(nodeSecond)
				.to(nodeThird)
				.to(nodeFourth)
				.to(nodeFifth)
				.calculate(new BruteForce());				
		List<CityNode> tourCities = tourResult.nodes();
		double tourDistance = tourResult.distance();
		System.out.println(tourDistance);
		System.out.println(Arrays.toString(tourCities.toArray()));
	}
}
