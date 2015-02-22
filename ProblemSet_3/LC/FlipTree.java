public class FlipTree {
	// Top Down 
	public static TreeNode flipUpDown(TreeNode root) {
		TreeNode p = root, parent = null, parentR = null;
		
		while(p != null) {
			TreeNode l = p.left;
			p.left = parentR;
			
			parentR = p.right;
			p.right = parent;
			
			parent = p;
			p = l;
		}
	 return root;
	}
	
	// Bottom up
	public static TreeNode flipUpDown(TreeNode root) {
		return bottomUp(root, null);
	}
	
	public static TreeNode flipUpDown(TreeNode p, TreeNode parent) {
		if(p == null) return parent;
		
		TreeNode root = flipUpDown(p.left, p);
		p.left = (parent == null) ? parent : parent.right;
		p.right = parent;
		
		return root;
	}
}