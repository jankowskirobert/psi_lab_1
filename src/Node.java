
public class Node {
	public double x;
	public double y;
	public boolean start = false;
	public boolean end = false;
	@Override
	public String toString() {
		return "Node "+start +" "+end+" [x=" + x + ", y=" + y + "]";
	}
	
}
