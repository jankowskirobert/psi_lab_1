package com.travelproblem.LAB_1;

import java.util.ArrayList;
import java.util.List;

public class Tour {

	List<CityNode> cities = new ArrayList<CityNode>();
	
	public Tour to(CityNode node) {
		this.cities.add(node);
		return this;
	}

	public TourResult calculate(Calculation type) {		
		return type.calculate(cities); 
	}

}
