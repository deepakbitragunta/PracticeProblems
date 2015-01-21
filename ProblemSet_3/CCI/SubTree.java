public class SubTree {

	public static boolean isSubTree(BinaryTree root1, BinaryTree root2) {
		if(root2 == null) {
			return true;
		}
		return contains(root1, root2);
	}
	public static boolean contains(BinaryTree root1, BinaryTree root2) {
		if(root1 == null) {
			return false;
		}
		if(root1.data == root2.data) {
			if(matchTree(root1, root2)) return true;
		}
		return contains(root1.left, root2) || contains(root1.right, root2);
	}
	public static boolean matchTree(BinaryTree root1, BinaryTree root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		
		if(root1.data != root2.data) return false;
		
		return matchTree(root1.left, root2.left) && matchTree(root1.right, root2.right); 
	}
	public static void main(String args[]) {
		BinaryTree root = new BinaryTree(15);
		BinaryTree.insert(root, 7);
		BinaryTree.insert(root, 12);
		BinaryTree.insert(root, 11);
		BinaryTree.insert(root, 14);
		BinaryTree.insert(root, 5);
		BinaryTree.insert(root, 8);
		BinaryTree.insert(root, 2);
		BinaryTree.insert(root, 18);		
		BinaryTree.insert(root, 6);
		BinaryTree.insert(root, 19);
		BinaryTree.insert(root, 17);
		BinaryTree.insert(root, 1);
		BinaryTree.insert(root, -7);
		BinaryTree.insert(root, -9);
		BinaryTree.insert(root, -17);
		BinaryTree root2 = new BinaryTree(1);
		BinaryTree.insert(root2, -7);
		BinaryTree.insert(root2, -9);
		BinaryTree.insert(root2, -17);
		System.out.println(isSubTree(root, root2));		
	}
}