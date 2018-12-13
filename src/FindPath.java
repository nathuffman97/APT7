
public class FindPath {
	private String finalPath = "nopath";
	public String path(TreeNode root, int target) {
        // write code here
		find(root, target, "");
        return finalPath;
    }
	
	private void find(TreeNode node, int target, String path) {
		if (node == null) return;
		if (node.info == target) {
			if (finalPath == "nopath" || finalPath.length() > path.length() ||
					(finalPath.length() == path.length() && finalPath.compareTo(path) > 0))
				finalPath = path;
			return;
		}
		
		find(node.left, target, path+"0");
		find(node.right, target, path+"1");
	}
}
