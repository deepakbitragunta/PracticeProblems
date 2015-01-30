import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	int data;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(int data) {
		this.data = data;
	}
	
	public static BinaryTree insert(BinaryTree root, int key) {
		if(root == null) {
			BinaryTree newNode = new BinaryTree(key);
			root = newNode;
		}
		else if(root.data > key) {
			root.left = insert(root.left, key);
		}
		else if(root.data < key) {
			root.right = insert(root.right, key);
		}
		return root;
	}
	
	public static BinaryTree findNode(BinaryTree root, int key) {
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
	public static void insertWithoutRec(BinaryTree root, int key) {
		BinaryTree  newNode = new BinaryTree(key);
		if(root == null) {
			root = newNode;
			return ;
		}
		
		BinaryTree temp = root;
		BinaryTree parent = null;
		
		while(temp != null) {
			parent = temp;
			if(key < temp.data) {
				temp = temp.left;
			}
			else if(key > temp.data) {
				temp = temp.right;
			}
			else {
			temp.data = key;
			return;
			}
		}
		if(key < parent.data) {
			parent.left =  new BinaryTree(key);	
		}
		else if(key > parent.data) {
			parent.right =  new BinaryTree(key);
		}
	//	return root;
	}
	
	public static BinaryTree deleteMin(BinaryTree node) {
		if(node.left == null) {
				return node.right;
		}
		node.left = deleteMin(node.left);
		return node;
	}
	
	public static BinaryTree deleteMax(BinaryTree node) {
		if(node.right == null) {
				return node.left;
		}
		node.right = deleteMax(node.right);
		return node;
	}
	
	public static boolean isValidBST(BinaryTree root, int min, int max) {
		if(root == null) { return true; }
		if(root.data <= min) return false;
		if(root.data >= max) return false;
		return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
	}
	
		
	public static boolean isValidBST(BinaryTree root, BinaryTree prev) {
		if(root == null) return true;
		
		if(root.left != null) {
			if(!isValidBST(root.left, root.left.left)) {
			return false;
			}
		}
		if(prev != null && prev.data > root.data) return false;
		
		return isValidBST(root.right, root);	
	}
	
	public static void levelOrderTraversal(BinaryTree root) {
		Queue<BinaryTree> q = new LinkedList<BinaryTree>();
		
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTree temp = q.remove();
			if(temp == null) { continue;}
			System.out.println(temp.data);
			q.add(temp.left);
			q.add(temp.right);
		}
	}
	public static int height(BinaryTree root) {
		if(root == null) return -1;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	public static BinaryTree delete(BinaryTree node, int key) {
		if(node == null) {
			return null;
		}
		if(key < node.data) {
			node.left = delete(node.left, key);
		}
		else if (key > node.data) {
			node.right = delete(node.right, key);
		}
		else {
			if(node.right == null) return node.left;
			if(node.left == null) return node.left;
			BinaryTree temp = node;
			node = min(temp.right);
			node.right = deleteMin(temp.right);
			node.left = temp.left;		
			}
		return node;
		}
		
		public static BinaryTree min(BinaryTree root) {
			if(root.left == null) return root;
			else return min(root.left);
		}
		
	public static void inOrderTraversal(BinaryTree root) {
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	
	}
	public static void preOrderTraversal(BinaryTree root) {
		if(root != null) {
			System.out.println(root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);			
		}
	}
	
	public static void postOrderTraversal(BinaryTree root) {
		if(root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data);
		}
	}
	
	public static void main(String args[]) {
		BinaryTree root = new BinaryTree(15);
		
	//	root.left = new BinaryTree(10);
	//	root.right = new BinaryTree(18);
		
	//	root.left.left = new BinaryTree(7);
	//	root.left.right = new BinaryTree(12);
		
	//	root.left.left.left = new BinaryTree(5);
	//	root.left.left.right = new BinaryTree(8);
		
	//	root.left.right.left = new BinaryTree(11);
	//	root.left.right.right = new BinaryTree(14);
		/*insert(root, 10);
		insert(root, 7);
		insert(root, 12);
		insert(root, 11);
		insert(root, 14);
		insert(root, 5);
		insert(root, 8);
		insert(root, 2);
		insert(root, 18);		
		insert(root, 6);
		insert(root, 19);
		insert(root, 17);
		insert(root, 1);
		insert(root, -7);
		insert(root, -9);
		insert(root, -17);
		root = new BinaryTree(16)*/;	
		insertWithoutRec(root, 10);
		insertWithoutRec(root, 7);
		insertWithoutRec(root, 12);
		insertWithoutRec(root, 11);
		insertWithoutRec(root, 14);
		insertWithoutRec(root, 5);
		insertWithoutRec(root, 8);
		insertWithoutRec(root, 2);
		insertWithoutRec(root, 18);		
		insertWithoutRec(root, 6);
		insertWithoutRec(root, 19);
		insertWithoutRec(root, 17);
		insertWithoutRec(root, 1);
		insertWithoutRec(root, -7);
		insertWithoutRec(root, -9);
		insertWithoutRec(root, -17);
		deleteMin(root);
		System.out.println("\n InOrder traversal : " );
		inOrderTraversal(root);
		deleteMax(root);
		System.out.println("\n InOrder traversal : " );
		inOrderTraversal(root);
		insertWithoutRec(root, 19);
		insertWithoutRec(root, 2);
		System.out.println("\n InOrder traversal : " );
		inOrderTraversal(root);
		delete(root, 10);
		System.out.println("\n InOrder traversal : " );
		inOrderTraversal(root);
		System.out.println("\n Level Order traversal : " );
		levelOrderTraversal(root);
		System.out.println("Validity");
		System.out.println(isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		root = new BinaryTree(1);
		root.left = new BinaryTree(1);
		
		System.out.println(isValidBST(root, null));
		
		/*System.out.println("\n PreOrder traversal: ");
		preOrderTraversal(root);
		System.out.println("\n PostOrder traversal : ");
		postOrderTraversal(root);	*/
	}
	
}