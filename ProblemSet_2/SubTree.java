package programs;

public class SubTree {

	public static boolean isIdentical(TreeNode s, TreeNode b) {
		if(s == null && b == null) {
			return true;
		}
		
		if(s == null || b == null) {
			return false;
		}
		
		return(s.val == b.val && isIdentical(s.left, b.left) && isIdentical(s.right, b.right));
	}
	
	public static boolean isSubTree(TreeNode s, TreeNode b) {
		if(s == null) {
			return true;
		}
		
		if(b == null) {
			return false;		
		}
		
		if(isIdentical(s, b)) {
			return true;
		}
		
		return isSubTree(s, b.left) || isSubTree(s, b.right);
	}
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(4);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node1.right = null;
		node2.left = node1;
		node2.right = node3;
		root.left = node2;
		root.right = node5;	

		TreeNode root2 = new TreeNode(2);
		TreeNode node6 = new TreeNode(6);
		root2.left = node6;
		
		System.out.println(isSubTree(root2, root));
	}
}