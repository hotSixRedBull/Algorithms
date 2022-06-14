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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> q1 = new ArrayDeque();
        Queue<TreeNode> q2 = new ArrayDeque();
        if ((root.left == null && root.right != null)
           ||(root.left != null && root.right == null)) {
            return false;
        }
        q1.add(root.left);
        q2.add(root.right);
        while (q1.size() > 0
              && q2.size() > 0) {
            TreeNode cur1 = q1.poll();
            TreeNode cur2 = q2.poll();
            if (cur1.val != cur2.val) {
                return false;
            }
            if (cur1.val == -101) {
                continue;
            }
            push(q1, cur1.left);
            push(q1, cur1.right);
            push(q2, cur2.right);
            push(q2, cur2.left);
        }
        return q1.size() == q2.size();
    }
    
    public void push(Queue<TreeNode> q, TreeNode node) {
        if (node == null) {
            q.add(new TreeNode(-101));
        }
        else {
            q.add(node);
        }
    }
}