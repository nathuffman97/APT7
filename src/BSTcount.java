import java.util.HashMap;
import java.util.Map;

public class BSTcount {
	private Map<Long, Long> mySavedValues = new HashMap<>();
	
	public long howMany(int[] values) {
		mySavedValues.put((long)0, (long)1);
		return helpcount(values.length);
	}

	private long helpcount(long size) {
		if (mySavedValues.containsKey(size)) {
			return mySavedValues.get(size);
		}
		
		long total  = 0;
		for (long i = 0; i < size; i++) {
			total += helpcount(i) * helpcount(size-1-i);
		}
		
		mySavedValues.put((long) size, total);
		return total;		
	}
}
