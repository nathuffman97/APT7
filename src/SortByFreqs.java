import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFreqs {
	public String[] sort(String[] data) {
        Map<String, Data> map = new HashMap<>();
        
        for (String s : data) {
        	map.putIfAbsent(s, new Data(s));
        	map.get(s).freq++;
        }
        
        List<Data> list = new ArrayList<>(map.values());
        
        Comparator<Data> comp = Comparator.comparing(Data::getFreq).reversed();
        comp = comp.thenComparing(Data::getName);
        
        Collections.sort(list, comp);
        
        String[] ret = new String[list.size()];
        
        for (int i = 0; i < ret.length; i++) {
        	ret[i] = list.get(i).name;
        }
        
        return ret;
    }
	
	class Data {
		String name;
		int freq;
		public Data(String n) {
			name = n;
			freq = 0;
		}
		public String getName() {
			return name;
		}
		public int getFreq() {
			return freq;
		}
	}
}
