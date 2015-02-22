public class BinaryTreeMinHeight {
	
	public static BinaryTree insert(int a[], int start, int end) {
		if(start > end) return null;
		int mid = start + ((end - start) / 2);	
		BinaryTree root = new BinaryTree(a[mid]);
		root.left = insert(a, start, mid - 1);
		root.right = insert(a, mid + 1, end);
		return root;
	}
	public static void main(String args[]) {
		int a[] = {2, 5, 8, 11, 14, 15, 16,20, 25, 26};
		BinaryTree root = null;
		root = insert(a, 0, a.length - 1);
		System.out.println(root.data);
		BinaryTree.inOrderTraversal(root);
	}
}