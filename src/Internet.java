import java.util.*;

public class Internet {
	Map<Integer, ArrayList<Integer>> graph;
	public int articulationPoints(String[] routers) {
        graph = new HashMap<>();
        makeGraph(routers);
        
        int count = 0;
        for (int i = 0; i < routers.length; i++) {
        	if (articulation(i) != routers.length) {
        		count ++;
        	}
        }
        return count;
    }
	
	private void makeGraph(String[] routers) {
		for (int i = 0; i < routers.length; i++) {
			graph.put(i, new ArrayList<Integer>());
			String[] connected = routers[i].split(" ");
			for (String conn : connected) {
				graph.get(i).add(Integer.parseInt(conn));
			}
		}
	}
	
	private int articulation(int skip) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		
		int start = skip == 0 ? skip + 1 : skip - 1;
		
		visited.add(start);
		visited.add(skip);
		q.add(start);
		
		while (q.size() > 0) {
			int router = q.poll();
			for (int adj : graph.get(router)) {
				if (!visited.contains(adj)) {
					visited.add(adj);
					q.add(adj);
				}
			}
		}
		
		return visited.size();
	}
}
