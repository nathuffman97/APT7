import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AuntUncle {
	Map<String, Person> children = new HashMap<>();
	public String[] list(String[] parents, String target) {
		fillMap(parents);

		String[] ret = getAU(target)
				.toArray(new String[0]);
		Arrays.sort(ret);
		
        return ret;
    }
	
	private void fillMap(String[] parents) {
		for (String s : parents) {
			String[] spl = s.split(" ");
			children.putIfAbsent(spl[2], new Person(spl[2]));
			children.putIfAbsent(spl[0], new Person(spl[0]));
			children.putIfAbsent(spl[1], new Person(spl[1]));
			
			children.get(spl[2]).parents.add(spl[0]);
			children.get(spl[2]).parents.add(spl[1]);
			
			children.get(spl[0]).children.add(spl[2]);
			children.get(spl[1]).children.add(spl[2]);
		}
		
	}
	
	private Set<String> getAU(String target) {
		Set<String> au = new HashSet<>();
		
		for (String parent : children.get(target).parents) {
			for (String grandparent : children.get(parent).parents) {
				au.addAll(children.get(grandparent).children);
			}
		}
		
		au.remove(target);
		au.removeAll(children.get(target).parents);
		return au;
	}
	
	class Person {
		String name;
		Set<String> parents = new HashSet<>();
		Set<String> children = new HashSet<>();
		
		public Person(String n) {
			name = n;
		}
	}
}
