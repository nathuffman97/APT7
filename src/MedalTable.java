import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedalTable {
	public String[] generate(String[] results) {
	    Map<String, Medal> map = new HashMap<>(); 
		for (String s : results) {
	    	 String[] data = s.split(" ");
	    	 for (int i = 0; i < 3; i++)
	    		 map.putIfAbsent(data[i], new Medal(data[i]));
	    	 map.get(data[0]).gold++;
	    	 map.get(data[1]).silver++;
	    	 map.get(data[2]).bronze++;
	     }
		
		List<Medal> list = new ArrayList<>(map.values());
		list.sort(Comparator.comparing(Medal::getCountry));
		list.sort(Comparator.comparing(Medal::getBronze).reversed());
		list.sort(Comparator.comparing(Medal::getSilver).reversed());
		list.sort(Comparator.comparing(Medal::getGold).reversed());
		
		String[] ans = new String[list.size()];
		for (int i = 0; i < list.size(); i++)
			ans[i] = list.get(i).toString();
		return ans;
	}
	
	class Medal {
		String country;
		int gold;
		int silver;
		int bronze;
		public Medal(String countryName) {
			country = countryName;
		}
		public String getCountry() {
			return country;
		}
		public int getGold() {
			return gold;
		}
		public int getSilver() {
			return silver;
		}
		public int getBronze() {
			return bronze;
		}
		
		@Override
		public String toString() {
			return country + " " + gold + " "
		+ silver + " " + bronze;
		}
	}
}
