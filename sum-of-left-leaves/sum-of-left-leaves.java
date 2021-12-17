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
    public int sumOfLeftLeaves(TreeNode root) {
        return recursive(false, root);
    }
    public int recursive(boolean isLeft, TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        if (isLeft && cur.left == null && cur.right == null) {
            return cur.val;
        }
        
        int ret = 0;
        ret += recursive(true, cur.left);
        ret += recursive(false, cur.right);
        return ret;
    }
}