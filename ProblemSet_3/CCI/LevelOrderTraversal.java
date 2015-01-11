import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrderTraversal {

	public static ArrayList<LinkedList<BinaryTree>> levelOrderDisplay(BinaryTree root) {
		if(root == null) return null;
		ArrayList<LinkedList<BinaryTree>> lists = new ArrayList<LinkedList<BinaryTree>>();
		BinaryTree temp = root;
		LinkedList<BinaryTree> level1 = new LinkedList<BinaryTree>();
		level1.add(root);
		lists.add(level1);
		int levelVisited = 0;
		while(true) {
			LinkedList<BinaryTree>	level = lists.get(levelVisited);
			LinkedList<BinaryTree> newLevel = new LinkedList<BinaryTree>();
			for(int i = 0; level != null && i < level.size(); ++i) {
				 temp = level.get(i);
				if(temp != null) {
					if(temp.left != null) { newLevel.add(temp.left); }
					if(temp.left != null) { newLevel.add(temp.right);}
				}	
			}
			if(newLevel.size() > 0) {
				lists.add(newLevel);
			}
			else {
				break;
			}
			levelVisited++;
		}	
		return lists;
	}		
			
	public static void main(String args[]) {
		BinaryTree root = new BinaryTree(15);
		BinaryTree.insert(root, 10);
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
		ArrayList<LinkedList<BinaryTree>> lists = levelOrderDisplay(root);
		for(int i = 0; i < lists.size(); ++i ) {
			for(int j = 0; j < lists.get(i).size(); ++j) {
				System.out.print(" " + lists.get(i).get(j).data);
			}
			System.out.println();
		}
	}


}