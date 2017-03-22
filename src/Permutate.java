import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Permutate {
	List<List<Node>> result;
	
	public static List<List<Node>> listPermutations(List<Node> list) {

	    if (list.size() == 0) {
	        List<List<Node>> result = new ArrayList<List<Node>>();
	        result.add(new ArrayList<Node>());
	        return result;
	    }

	    List<List<Node>> returnMe = new ArrayList<List<Node>>();

	    Node firstElement = list.remove(0);

	    List<List<Node>> recursiveReturn = listPermutations(list);
	    for(int j = 0 ; j< (recursiveReturn.size()) ; j++){
	        for (int index = 0; index <= recursiveReturn.get(j).size(); index++) {
	            List<Node> temp = new ArrayList<Node>(recursiveReturn.get(j));
	            temp.add(index, firstElement);
	            returnMe.add(temp);
	        }
	    }
	    return returnMe;
	}
	
	public static double betweenNodes(Node one, Node two){
		double distance = Math.sqrt((one.x-two.x)*(one.x-two.x) + (one.y-two.y)*(one.y-two.y));
		return distance;		
	}
	
	public static void main(String[] args) {
		Node n1 = new Node();
		n1.x = 5;
		n1.y = 6;
		Node n2 = new Node();
		n2.x = 5;
		n2.y = 7;
		Node n3 = new Node();
		n3.x = 5;
		n3.y = 9;
		Node n4 = new Node();
		n4.x = 5;
		n4.y = 19;
		Node n5 = new Node();
		n5.x = 5;
		n5.y = 1;
		List<Node> nodes = new ArrayList<>();
		nodes.add(n1);
		nodes.add(n2);
		nodes.add(n3);
		nodes.add(n4);
		nodes.add(n5);
		List<List<Node>> resultPermutation = listPermutations(nodes);
		Map<List<Node>, Double> output = new HashMap<>();
		for(List<Node> ns : resultPermutation){
			double distance = 0;
			for(int i = 0 ;i < ns.size()-1 ; i++){
				distance += betweenNodes(ns.get(i), ns.get(i+1));
			}
		output.put(ns, distance);
			System.out.println(ns + " " + distance);
		}
		final Comparator<? super Entry<List<Node>, Double>> comp = (p1, p2) -> Double.compare(p1.getValue(), p2.getValue());
		System.out.println();
		System.out.println(output.entrySet().stream().min(comp).get().getKey());
	}
}
