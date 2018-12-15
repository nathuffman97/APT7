import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {
	public String[] dataCleanup(String[] names) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].indexOf(",") != -1) {
				String[] spl = names[i].split(", ");
				names[i] = spl[1] + " " + spl[0];
			}
		}
		
		Person[] people = new Person[names.length];
		for (int i = 0; i < names.length; i++)
			people[i] = new Person(names[i]);
		
		Comparator<Person> comp = Comparator.comparing(Person::getLast);
		comp = comp.thenComparing(Person::getFirst);
		Arrays.sort(people, comp);
		
		for (int i = 0; i < names.length; i++) {
			names[i] = people[i].toString();
		}
		
		return names;
	}
	
	class Person {
		String last;
		String first;
		public Person(String name) {
			String[] s = name.split(" ");
			first = s[0];
			last = s[1];
		}
		public String getFirst() {
			return first;
		}
		public String getLast() {
			return last;
		}
		
		@Override
		public String toString() {
			return first + " " + last;
		}
	}
}
