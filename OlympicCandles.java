import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class OlympicCandles {
	public int numberOfNights(int[] candles){
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int candle : candles)
			q.add(candle);
		
		int day = 1;
		while (q.size() >= day) {
			Queue<Integer> tempHolding = new LinkedList<>();
			for (int i = 0; i < day; i++) {
				int candle = q.poll() - 1;
				if (candle != 0)
					tempHolding.add(candle);
			}
			q.addAll(tempHolding);
			day++;
		}
		
		return day - 1;
	}
}
