import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SyllableSorting {
	public String[] sortWords(String[] words) {
		Arrays.sort(words, new SyllComp());
		return words;
	}
	
	class SyllComp implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			List<String> s1 = vowelSplit(arg0);
			List<String> s2 = vowelSplit(arg1);
			
			Collections.sort(s1);
			Collections.sort(s2);
			
			int comp = compare(s1, s2);
			if (comp != 0) return comp;
			
			s1 = vowelSplit(arg0);
			s2 = vowelSplit(arg1);
			
			return compare(s1, s2);
		}
		
		public int compare(List<String> l1, List<String> l2) {
			int len = Math.min(l1.size(), l2.size());
			
			for (int i = 0; i < len; i++) {
				int comp = l1.get(i).compareTo(l2.get(i));
				if (comp != 0) return comp;
			}
			
			return l1.size() - l2.size();
		}

		private List<String> vowelSplit(String s) {
			List<String> list = new ArrayList<>();
			
			int start = 0; int end = 1;
			for (int i = 0; i < s.length(); i++) {
				if (isVowel(s.charAt(i))) {
					if (i == s.length() - 1 ||
							!isVowel(s.charAt(i+1))) {
						list.add(s.substring(start, end));
						start = end;
					}
				}
				end++;
			}
			return list;
		}

		private boolean isVowel(char c) {
			return c == 'a' || c == 'e' || c == 'i' ||
					c == 'o' || c == 'u';
		}
		
	}
}
