import java.util.LinkedList;
import java.util.Queue;

public class TreeSome {
	public int count(TreeNode root, int low, int high) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int count = 0;
		
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node == null) continue;
			
			if (node.info <= high && node.info >= low)
				count++;
			q.add(node.left);
			q.add(node.right);
		}
		
        return count;
    }
}
