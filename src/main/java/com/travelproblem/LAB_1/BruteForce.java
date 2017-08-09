package com.travelproblem.LAB_1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class BruteForce implements Calculation {

	private static final Logger LOG = Logger.getLogger(BruteForce.class.getName());
	private List<List<CityNode>> listPermutations(List<CityNode> list) {

	    if (list.size() == 0) {
	        List<List<CityNode>> result = new ArrayList<List<CityNode>>();
	        result.add(new ArrayList<CityNode>());
	        return result;
	    }

	    List<List<CityNode>> returnMe = new ArrayList<List<CityNode>>();

	    CityNode firstElement = list.remove(0);

	    List<List<CityNode>> recursiveReturn = listPermutations(list);
	    for(int j = 0 ; j< (recursiveReturn.size()) ; j++){
	        for (int index = 0; index <= recursiveReturn.get(j).size(); index++) {
	            List<CityNode> temp = new ArrayList<CityNode>(recursiveReturn.get(j));
	            temp.add(index, firstElement);
	            returnMe.add(temp);
	        }
	    }
	    return returnMe;
	}
	
	public TourResult calculate(List<CityNode> nodes) {
		List<List<CityNode>> permutedNodes = listPermutations(nodes);
		LOG.info(Arrays.toString(permutedNodes.toArray()));
		List<CityNode> result = null;
		double target = Double.MAX_VALUE;
		for (List<CityNode> list : permutedNodes) {
			double localTarget = 0;
			for (int i = 0; i < list.size()-1; i++) {
				CityNode cityNode = list.get(i);				
				localTarget += cityNode.distance(list.get(i+1));
			}
			if(Double.compare(target, localTarget) >= 0){
				target = localTarget;
				result = list;
				LOG.info("Distance: " + localTarget);
			}
		}
		return new TourResult(target, result);
	}

}
