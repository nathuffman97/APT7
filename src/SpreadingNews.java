import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpreadingNews {
	private Map<Integer, ArrayList<Integer>> mySups;
	
	public int minTime(int[] supervisors) {
		mySups = new HashMap<>();
		makeGraph(supervisors);
		return minTime(0);
	}
	
	private void makeGraph(int[] supervisors) {
		mySups.put(0, new ArrayList<>());
		for (int i = 1; i < supervisors.length; i++) {
			mySups.putIfAbsent(i, new ArrayList<>());
			mySups.get(supervisors[i]).add(i);
		}
	}
	
	private int minTime(int boss) {
		List<Integer> times = new ArrayList<>();
		for (int i : mySups.get(boss)) {
			times.add(minTime(i));
		}
		
		Collections.sort(times, Collections.reverseOrder());;
		
		int max = 0;
		for (int i = 0; i < times.size(); i++) {
			int time = 1 + i + times.get(i);
			if (time > max)
				max = time;
		}
		
		return max;
	}
}
