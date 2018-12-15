import java.util.Arrays;
import java.util.Comparator;

public class Dirsort {
	public String[] sort(String[] dirs) {
		Arrays.sort(dirs, new DirComp());
		return dirs;
	}
	
	class DirComp implements Comparator<String> {

		@Override
		public int compare(String dir1, String dir2) {
			String[] d1 = dir1.split("/");
			String[] d2 = dir2.split("/");
			
			int len = d1.length - d2.length;
			if (len != 0) return len;
			
			for (int i = 0; i < d1.length; i++) {
				int comp = d1[i].compareTo(d2[i]);
				if (comp != 0) return comp;
			}
			
			return 0;
		}
		
	}
}
