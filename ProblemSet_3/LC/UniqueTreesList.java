import java.util.List;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class UniqueTreesList {
    public List<TreeNode> generateTrees(int n) {
       return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(l > r) {
            list.add(null);
            return list;
        }
        
        for(int i = l; i <= r; ++i) {
            List<TreeNode> leftTrees = generateTrees(l, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, r);
            for(TreeNode t1 : leftTrees) {
                for(TreeNode t2 : rightTrees) {
                   TreeNode newNode = new TreeNode(i);
                   newNode.left = t1;
                   newNode.right = t2;
                   list.add(newNode);
                }
            }
        }
        return list;
    }
}