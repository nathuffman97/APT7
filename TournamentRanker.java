import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TournamentRanker {
	Map<String, Stats> info = new HashMap<>();

	public String[] rankTeams(String[] names, String[] lostTo) {
		for (int i = 0; i < names.length; i++) {
			info.putIfAbsent(names[i], new Stats());
			info.putIfAbsent(lostTo[i], new Stats());
			
			info.get(names[i]).lostTo = lostTo[i];
			info.get(lostTo[i]).beat.add(names[i]);
		}
		
		Arrays.sort(names, new RankComp());
		
		return names;
	}
	
	class Stats {
		String lostTo;
		ArrayList<String> beat = new ArrayList<>();
	}
	
	class RankComp implements Comparator<String> {
		
		@Override
		public int compare(String team1, String team2) {
			int diff = info.get(team2).beat.size() - info.get(team1).beat.size();
			if (diff == 0) {
				return new RankComp()
						.compare(info.get(team1).lostTo, info.get(team2).lostTo);
			}
			return diff;
		}
	}
}
