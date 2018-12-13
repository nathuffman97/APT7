
public class PrefixCode {
	public String isOne(String[] words) {
		int dex = words.length;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (i == j) continue;
				if (words[i].startsWith(words[j]))
					if (j < dex)
						dex = j;
			}
		}
		
		return dex == words.length ? "Yes" : String.format("No, %d", dex);
	}
}