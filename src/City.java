
public class City {
	private final String name;
	private final double position_x;
	private final double position_y;
	public City(String name, double position_x, double position_y) {
		super();
		this.name = name;
		this.position_x = position_x;
		this.position_y = position_y;
	}
	public String getName() {
		return name;
	}
	public double getPosition_x() {
		return position_x;
	}
	public double getPosition_y() {
		return position_y;
	}
	public double distanceToCity(City city) {
        double x = getPosition_x() - city.getPosition_x();
        double y = getPosition_y() - city.getPosition_y();
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
	
}
