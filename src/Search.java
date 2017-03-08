import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Search {
	private ArrayList<City> trip;
	private List<Path> paths;
	
	public Search() {
		trip = new ArrayList<>();
		trip.add(new City("Lodz", 2, 5));
		trip.add(new City("Warszawa", 6, 7));
		trip.add(new City("Poznan", 8, 1));
		trip.add(new City("Gdansk", 12, 5));
	}
	
	public void searchPath(){
		Iterator<City> itr = trip.iterator();
		while(itr.hasNext()){
			City whereIam = itr.next();
			
		}
	}
	
	private List<City> childCity(ArrayList<City> cities, City city){
		ArrayList<City> tmpCities = new ArrayList<>();
		for(City c : cities)
			if(!c.equals(city))
				tmpCities.add(c);
		return tmpCities;
	}
	
	private void permute(List<City> arr, int k){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
        	Path path = new Path(arr);
        	paths.add(path);
            System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
    }
}
