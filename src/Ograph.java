import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Ograph {
	Map<Integer, ArrayList<Integer>> graphs = new HashMap<>();
	Set<Integer> nodes = new HashSet<>();
	
	public int[] components(String[] data) {
		makeGraphs(data);
		nodes.addAll(graphs.keySet());
		
		List<Integer> sizes = new ArrayList<>();
		while(nodes.size() != 0)
			sizes.add(bfs(nodes.toArray(new Integer[0])[0]));
		
		Collections.sort(sizes);
		int[] ret = new int[sizes.size()];
		for (int i = 0; i < sizes.size(); i++)
			ret[i] = sizes.get(i);

        return ret;
    }

	private void makeGraphs(String[] data) {
		for (int i = 0; i < data.length; i++) {
			graphs.put(i, new ArrayList<Integer>());
			String[] connections = data[i].split(" ");
			for (String conn : connections)
				graphs.get(i).add(Integer.parseInt(conn));
		}
	}
	
	private int bfs(Integer start) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		visited.add(start);
		nodes.remove(start);
		
		while (!q.isEmpty()) {
			Integer node = q.poll();
			for (Integer conn : graphs.get(node)) {
				if (!visited.contains(conn)) {
					visited.add(conn);
					q.add(conn);
					nodes.remove(conn);
				}
			}
		}
		
		return visited.size();
	}
}
