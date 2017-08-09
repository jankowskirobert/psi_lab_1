package com.travelproblem.LAB_1;

import java.util.List;

public class TourResult {

	private double distance;
	private List<CityNode> result;

	public TourResult(double distance, List<CityNode> result) {
		this.distance = distance;
		this.result = result;
	}

	public double distance() {
		return distance;
	}
	
	public List<CityNode> nodes() {
		return result;
	}
}
