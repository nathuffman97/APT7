import java.util.*;

public class ErdosNumber {
	private Map<String, Set<String>> myGraph;
	private Map<String, Integer> myDistance;

	public String[] calculateNumbers(String[] pubs) {
		myGraph = new TreeMap<>();
		myDistance = new TreeMap<>();
		makeGraph(pubs);
		List<String> list = new ArrayList<>();
		bfsErdos();
		for (String s : myGraph.keySet()) {
			if (myDistance.containsKey(s))
				s = s + " " + myDistance.get(s);
			list.add(s);
		}
		return list.toArray(new String[0]);
	}

	private void makeGraph(String[] pubs) {
		for (String p:pubs) {
			String[] authors = p.split(" ");
			for (String auth: authors) {
				List<String> list = new ArrayList<>(Arrays.asList(authors));
				myGraph.putIfAbsent(auth, new TreeSet<String>());
				myGraph.get(auth).addAll(list);
			}
		}
	}

	private void bfsErdos() {
		Set<String> visited = new TreeSet<>();
		Queue<String> q = new LinkedList<>();
		
		myDistance.put("ERDOS", 0);
		visited.add("ERDOS");
		q.add("ERDOS");
		
		while (q.size() > 0) {
			String auth = q.remove();
			for (String coauth: myGraph.get(auth)) {
				if (!visited.contains(coauth)) {
					myDistance.put(coauth, myDistance.get(auth) + 1);
					visited.add(coauth);
					q.add(coauth);
				}
			}
		}
	}
}
