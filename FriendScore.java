import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FriendScore {
	Map<Integer, Set<Integer>> friendMap;
	public int highestScore(String[] friends) {
		friendMap = new HashMap<>();
		buildMap(friends);
		
		int max = 0;
		for (int i = 0; i < friends.length; i++) {
			max = Math.max(max, calc2Friends(i));
		}
        
		return max;
     }
	
	private void buildMap(String[] friends) {
		for (int i = 0; i < friends.length; i++) {
			String[] letters = friends[i].split("");
			friendMap.putIfAbsent(i, new HashSet<Integer>());
			for (int j = 0; j < letters.length; j++) {
				if (letters[j].equals("Y"))
					friendMap.get(i).add(j);
			}
		}
	}

	private int calc2Friends(int i) {
		Set<Integer> friends = new HashSet<>();
		friends.addAll(friendMap.get(i));
		
		for (int friend : friendMap.get(i))
			friends.addAll(friendMap.get(friend));
		
		friends.remove(i);
		return friends.size();
	}
}
