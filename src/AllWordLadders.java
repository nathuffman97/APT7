import java.util.*;

public class AllWordLadders {
	public int[] solve(String[] words,  String from, String to) {
        Queue<String> q = new LinkedList<>();  // Queue for BFS
        Set<String> visited = new TreeSet<>();  // All vertices visited so far
        Map<String, Integer> distance = new TreeMap<>();  // Shortest distance from the starting point to the key
        Map<String, Integer> ladderCount = new TreeMap<>();  // Number of shortest word ladders from the starting point to the key (with distance stored in distance map)
        
        // Generate all possible starting points (1 away from start)
        for (String s : words) {
        	if (oneAway(from, s)) {
        		q.add(s);
        		// Initialize variables
        		visited.add(s);
        		distance.put(s, 2);
        		ladderCount.put(s, 1);  // only 1 ladder possible
        	}
        }
        
        int minDist = Integer.MAX_VALUE;  // Shortest distance to the ending point we found so far
        int numLadders = 0;
        // BFS
        while (q.size() > 0) {
        	String s = q.remove();
        	if (oneAway(s, to)) {  // Reach ending point
        		if (distance.get(s) + 1 <= minDist) {
        			// Shortest distance found; record down the distance
        			minDist = distance.get(s) + 1;
        			numLadders += ladderCount.get(s);
        		} else {
        			// Current vertex is already further than the ending point.
        			// No need to keep searching: Can only find longer paths
        			break;
        		}
        	}
        	// Loop over neighbors
        	for (String adj : words) {
        		if (oneAway(s, adj)) {
	        		if (!visited.contains(adj)) {  // adj has not been visited before
	        			visited.add(adj);
	        			q.add(adj);
	        			distance.put(adj, distance.get(s)+1);
	        			ladderCount.put(adj, ladderCount.get(s));  // All ladders to s can also go to adj
	        		} else if (distance.get(adj) == distance.get(s) + 1) {
	        			// adj was found before and will be visited soon (why?), but we've found alternative paths to adj
	        			// Again, all ladders to s can also go to adj
	        			ladderCount.put(adj, 
	        					ladderCount.get(adj) + ladderCount.get(s));
	        		}
        		}
        	}
        }
        
        if (minDist == Integer.MAX_VALUE) minDist = 0;
        int[] ans = {minDist, numLadders};
        return ans;
    }
	
	/**
	 * Compares two strings and check if they're one character away.
	 * @param a String 1
	 * @param b String 2
	 * @return true iff a and b have at most one different character
	 */
	private boolean oneAway(String a, String b) {
		boolean diff = false;
		for (int i=0; i<a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				if (diff) {
					return false;
				} else {
					diff = true;
				}
			}
		}
		return diff;
	}
}
