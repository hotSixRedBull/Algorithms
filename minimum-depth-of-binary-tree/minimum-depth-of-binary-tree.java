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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<Integer> depthQ = new ArrayDeque<>();
        q.add(root);
        depthQ.add(1);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            int depth = depthQ.poll();
            if (cur.left == null && cur.right == null) {
                return depth;
            }
            if (cur.left != null) {
                q.add(cur.left);
                depthQ.add(depth+1);
            }
            if (cur.right != null) {
                q.add(cur.right);
                depthQ.add(depth+1);
            }
        }
        return 0;
    }
}