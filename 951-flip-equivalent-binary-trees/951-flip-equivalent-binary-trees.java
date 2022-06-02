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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            if (root2 == null) {
                return true;
            }
            else {
                return false;
            }
        }
        if (root2 == null) {
            if (root1 == null) {
                return true;
            }
            else {
                return false;
            }
        }
        
        if (root1.val != root2.val) {
            return false;
        }
        boolean ret = false;
        ret |= flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        ret |= flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        return ret;
    }
}