public class BalancedTree {
	public static int minDepth(BinaryTree root) {
		if(root == null) { return 0 ; }
		
		return 1 + (Math.min(minDepth(root.left), minDepth(root.right)));
	
	}
	public static int maxDepth(BinaryTree root) {
		if(root == null) { return 0 ; }	
		return 1 + (Math.max(maxDepth(root.left), maxDepth(root.right)));	
	}
	
	public static boolean isBalanced(BinaryTree root) {
		return (maxDepth(root) - minDepth(root) <= 1);
	}
	
	public static void main(String args[]) {
		BinaryTree root = new BinaryTree(15);
		BinaryTree.insert(root, 7);
		BinaryTree.insert(root, 12);
		BinaryTree.insert(root, 11);
		BinaryTree.insert(root, 14);
		BinaryTree.insert(root, 5);
		
		BinaryTree.insert(root, 18);		
		BinaryTree.insert(root, 6);
		BinaryTree.insert(root, 19);
		BinaryTree.insert(root, 17);
		System.out.println(isBalanced(root));
	}
}
	