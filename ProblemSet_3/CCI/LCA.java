public class LCA {
	
/*	// With parent pointer
	public static BTree findAncestor1(BTree node1, BTree node2) {		
		if(node1.parent == null) return node1;
		if(node2.parent == null) return node2;
		
		if(node1 == node2) return node1;
		BTree node11 = findAncestor1(node1.parent, node2);
		BTree node21 = findAncestor1(node1, node2.parent);
		return node21;
	}*/
	//
	public static BinaryTree findAncestor2(BinaryTree root, BinaryTree n1, BinaryTree n2) {		
		if(covers(root.left, n1) && covers(root.left, n2)) {
			return	findAncestor2(root.left, n1, n2);
		}
		
		if(covers(root.right, n1) && covers(root.right, n2)) {
			return findAncestor2(root.right, n1, n2);
		}
		
		return root;		
	}
	// check if node is a children of root
	public static boolean covers(BinaryTree root, BinaryTree node){ 
		if(root == null) return false;
		
		if(root == node) return true;
		
		return covers(root.left, node) || covers(root.right, node);
	}
	public static void main(String args[]) {
		BTree root = new BTree(15);
		BTree.insert(root, 10);	
		BTree.insert(root, 7);
		BTree.insert(root, 12);
		BTree.insert(root, 11);
		BTree.insert(root, 14);
		BTree.insert(root, 5);
		BTree.insert(root, 8);
		BTree.insert(root, 2);
		BTree.insert(root, 18);		
		BTree.insert(root, 6);
		BTree.insert(root, 19);
		BTree.insert(root, 17);
		BTree.insert(root, 1);
		BTree.insert(root, -7);
		BTree.insert(root, -9);
		BTree.insert(root, -17);
	
	//	System.out.println("\n Ancestor: " + findAncestor1(BTree.findNode(root, 7), BTree.findNode(root, 9)).data);
	//	BinaryTree root1 = new BinaryTree(15);
		BinaryTree.insertWithoutRec(root, 10);
		BinaryTree.insertWithoutRec(root, 7);
		BinaryTree.insertWithoutRec(root, 12);
		BinaryTree.insertWithoutRec(root, 11);
		BinaryTree.insertWithoutRec(root, 14);
		BinaryTree.insertWithoutRec(root, 5);
		BinaryTree.insertWithoutRec(root, 8);
		BinaryTree.insertWithoutRec(root, 2);
		BinaryTree.insertWithoutRec(root, 18);		
		BinaryTree.insertWithoutRec(root, 6);
		BinaryTree.insertWithoutRec(root, 19);
		BinaryTree.insertWithoutRec(root, 17);
		BinaryTree.insertWithoutRec(root, 1);
		BinaryTree.insertWithoutRec(root, -7);
		BinaryTree.insertWithoutRec(root, -9);
		BinaryTree.insertWithoutRec(root, -17);
		
		System.out.println("\n Ancestor: " + findAncestor2(root, BinaryTree.findNode(root, 7), BinaryTree.findNode(root, 19)).data);
		System.out.println("\n Least Ancestor: " + findLeastAncestor(root, BinaryTree.findNode(root, 7), BinaryTree.findNode(root, 19)).data);
		
	}
	
	public static BinaryTree findLeastAncestor(BinaryTree root, BinaryTree node1, BinaryTree node2) {
		if(root == null) return null;
		
		if(root == node1 || root == node2) {
			return root;
		}
		
		BinaryTree l = findLeastAncestor(root.left, node1, node2);
		BinaryTree r = findLeastAncestor(root.right, node1, node2);
		
		if(l != null && r != null) {
			return root;
		}	
		return l != null ? l : r;
	} 
}