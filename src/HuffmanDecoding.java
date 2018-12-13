import java.util.HashMap;
import java.util.Map;

public class HuffmanDecoding {
	public String decode(String archive, String[] dictionary) {
		StringBuilder ans = new StringBuilder();
		Map<String, String> dict = buildMap(dictionary);
		
		int start = 0;
		int end = 1;
		for (int i = 0; i < archive.length(); i++) {
			String sub = archive.substring(start, end);
			if (dict.containsKey(sub)) {
				ans.append(dict.get(sub));
				start = end;
			}
			end++;
		}

		return ans.toString();
	}

	private Map<String, String> buildMap(String[] dictionary) {
		Map<String, String> dict = new HashMap<>();

		for (int i = 0; i < dictionary.length; i++) {
			String val = ((char) ((int) 'A' + i)) + "";
			dict.put(dictionary[i], val);
		}

		return dict;
	}
}
