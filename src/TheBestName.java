import java.util.Arrays;
import java.util.Comparator;

public class TheBestName {
	public String[] sort(String[] names) {
        Arrays.sort(names, new JohnComp());
        return names;
	}
	
	class JohnComp implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			if (s1.equals("JOHN")) return -1;
			if (s2.equals("JOHN")) return 1;
			
			int diff = calcScore(s2) - calcScore(s1);
			
			if (diff == 0)
				return s1.compareTo(s2);
			
			return diff;
		}
		
		private int calcScore(String name) {
			int count = 0;
			
			for (char c : name.toCharArray()) {
				count += (int) c - 'A' + 1;
			}
			
			return count;
		}
	}
}
