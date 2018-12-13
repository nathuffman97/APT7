import java.util.Collections;
import java.util.PriorityQueue;

public class VoteRigging {
	public int minimumVotes(int[] votes) {
		if (votes.length == 1) return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 1; i < votes.length; i++)
        	q.add(votes[i]);
        
        int count = 0;
        while (q.peek() >= votes[0]) {
        	int top = q.poll();
        	top --;
        	votes[0]++;
        	count ++;
        	q.add(top);
        }
        
        return count;
    }
}
