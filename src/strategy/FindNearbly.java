package strategy;

import point.Point;

public class FindNearbly implements HeuresticStrategy {
	
	@Override
	public double getResult(Point... args) {	
		return args[0].distance(args[1]);
	}

}
