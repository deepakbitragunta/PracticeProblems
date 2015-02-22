/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
/*    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        
        if(root == null) {
            return paths;    
        }
        List<Integer> row = new ArrayList<Integer>();
        
        pathSum(root, row, paths, sum);
        
        return paths;
    }
    
    public void pathSum(TreeNode root,  List<Integer> row, List<List<Integer>> paths,  int sum) {
        if(root == null) {
            return;
        }
        
        sum = sum - root.val;
        row.add(root.val);
        
        if(sum == 0 && root.left == null && root.right == null) {
            paths.add(new ArrayList(row));
            
        } else {
            pathSum(root.left, row, paths, sum);
            pathSum(root.right, row, paths, sum);
        }
        row.remove(row.size() - 1);
    }
    */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        
        if(root == null) {
            return paths;
        }
        List<Integer> row = new ArrayList<Integer>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> v = new LinkedList<Integer>();
        Queue<List<Integer>> r = new LinkedList<List<Integer>>();
        TreeNode temp;
        int val;
        
        q.add(root);
        v.add(0);
        r.add(new ArrayList<Integer>());
        
        while(!q.isEmpty() && !v.isEmpty() && !r.isEmpty()) {
           temp = q.poll();
           val = v.poll();
           row = r.poll();
           
           val = sum - val - temp.val;
           row.add(temp.val);
           if(val == 0 && temp.left == null && temp.right == null) {
               paths.add(new ArrayList<Integer>(row));
           }
           if(temp.left != null) {
               q.add(temp.left);
               v.add(val);
               r.add(new ArrayList<Integer>(row));
           }
           
           if(temp.right != null) {
              q.add(temp.right);
              v.add(val);
              r.add(new ArrayList<Integer>(row));
           }
           
        }
        return paths;
    }
}