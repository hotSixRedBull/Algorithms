/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();
        
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root1);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            set1.add(cur.val);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        q.add(root2);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            set2.add(cur.val);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        
        for (int tree1 : set1) {
            if (set2.contains(target-tree1)) {
                return true;
            }
        }
        return false;
    }
}