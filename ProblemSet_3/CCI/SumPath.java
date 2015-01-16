import java.util.ArrayList;

public class SumPath {

	@SuppressWarnings("unchecked")
	public static void printPaths(BinaryTree root, ArrayList<Integer> buffer, int sum, int level) {
		if(root == null) return;
		
		buffer.add(root.data);
		int temp = sum;
		for(int i = level; i > -1; --i) {
			temp -= buffer.get(i);
			if(temp == 0) print(buffer, i, level);
		}
			ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
			ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
			
			printPaths(root.left, c1, sum, level + 1);
			printPaths(root.right, c2, sum, level + 1);
	}
	
	public static void print(ArrayList<Integer> buffer, int level, int i) {
		for(int j = level; j <= i; ++j) {
			System.out.println(buffer.get(j));
		}
		System.out.println();
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
		printPaths(root, new ArrayList<Integer>(), 8, 0);
		
	
	}
}