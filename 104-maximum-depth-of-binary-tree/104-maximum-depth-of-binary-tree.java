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
    int ans;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        recursive(root, 0);
        return ans;
    }
    
    public void recursive(TreeNode cur, int depth) {
        if (cur == null) {
            ans = Math.max(ans, depth);
            return;
        }
        recursive(cur.left, depth+1);
        recursive(cur.right, depth+1);
    }
}