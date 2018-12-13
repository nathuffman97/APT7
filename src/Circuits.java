import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Circuits {
	Map<Integer, ArrayList<Connection>> graph;

	public int howLong(String[] connects, String[] costs) {
		graph = new HashMap<>();
		makeGraph(connects, costs);
		
		List<Integer> paths = new ArrayList<>();
		for (int i = 0; i < connects.length; i++) {
			paths.add(dfs(i, 0));
		}
		
		return Collections.max(paths);
	}
	
	private void makeGraph(String[] connects, String[] costs) {
		for (int i = 0; i < connects.length; i++) {
			graph.put(i, new ArrayList<Connection>());
			if (connects[i].length() == 0) continue;
			
			String[] conn = connects[i].split(" ");
			String[] weight = costs[i].split(" ");
			for (int j = 0; j < conn.length; j++) {
				Connection c = new Connection(Integer.parseInt(conn[j]),
						Integer.parseInt(weight[j]));
				graph.get(i).add(c);
			}
		}
		
	}
	
	private int dfs(int comp, int path) {
		if (graph.get(comp).size() == 0) return path;
		
		List<Integer> paths = new ArrayList<>();
		for (Connection c : graph.get(comp)) {
			paths.add(dfs(c.component, path + c.cost));
		}
		
		return Collections.max(paths);
	}

	class Connection {
		int component;
		int cost;
		public Connection(int comp, int weight) {
			component = comp;
			cost = weight;
		}
	}
}
