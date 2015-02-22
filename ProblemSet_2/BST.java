// http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

package programs;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
 
	TreeNode(int x) {
		val = x;
	}
}
 
public class BST {
 
	public static boolean isValidBST(TreeNode root) {
		return validate(root, null, null);
	}
 
	public static boolean validate(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
 
		if (min != null && root.val <= min) return false;
       
		if (max != null && root.val >= max) return false;

 
		// left subtree must be < root.val && right subtree must be > root.val
		return validate(root.left, min, root.val ) && validate(root.right, root.val , max);
	}
	
	public static boolean isBST2(TreeNode r) {
		return isBST2Impl(r, null);
	}

	private static boolean isBST2Impl(TreeNode r, TreeNode prev) {
		if (r == null) {
			return true;
		}

		if (r.left != null) {
			if (!isBST2Impl(r.left, r.left.left)) {
				return false;
			}
		}

		if (prev != null && prev.val > r.val) {
			return false;
		}

		return isBST2Impl(r.right, r);
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
		
	//	System.out.println(isValidBST(root));
		System.out.println(isBST2(root));
	}
	
	
}