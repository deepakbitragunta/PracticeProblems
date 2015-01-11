class BTree extends BinaryTree {
	BTree parent;
	BTree left;
	BTree right;
	int data;
	public BTree(int data) {
		super(data);
		this.data = data;
	}
		public static BTree findNode(BTree root, int key) {
		if(root == null) return null;
		
		if(key < root.data) {
			return	findNode(root.left, key);
		} 
		else if(key > root.data) {
			return findNode(root.right, key);
		}
		else {
			return root;
		}
		
	}
	
	public static BTree insert(BTree root, int key) {
		if(root == null) {
			BTree newNode = new BTree(key);
			root = newNode;
		}
		else if(root.data > key) {
			root.left = insert(root.left, key);
			root.left.parent = root;
		}
		else if(root.data < key) {
			root.right = insert(root.right, key);
			root.right.parent = root;
		}
		return root;
	}
	public static void inOrderTraversal(BTree root) {
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}
}

public class InOrderSuccessor {
	
	public static BTree leftMost(BTree node) {
		if(node.left == null) return node;
		return leftMost(node.left);
	}
	public static BTree findSuccessor(BTree node) {
		if(node == null) return null;
		BTree s;
		if(node.parent == null || node.right != null) {
			s = leftMost(node.right);
		}
		else {
				while((s = node.parent) != null) {
					if(s.left == node) {
						break;
					}
					node = s;
				}	
		}
		return s;
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
		System.out.println("Inorder: ");
		BTree.inOrderTraversal(root);
		System.out.println("\n Successor: " + findSuccessor(BTree.findNode(root, 8)).data);
	}
}
	
