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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, false, 0, false, 0);
    }
    public boolean isValid(TreeNode cur,
                           boolean hasLowerBound,
                           int lowerBound,
                           boolean hasUpperBound,
                           int upperBound) {
        if (cur == null) {
            return true;
        }
        if (hasLowerBound
           && cur.val <= lowerBound) {
            return false;
        }
        if (hasUpperBound
           && cur.val >= upperBound) {
            return false;
        }
        if (cur.left == null
            && cur.right == null) {
            return true;
        }
        
        boolean ret = true;
        if (cur.left != null) {
            if (hasUpperBound) {
                ret &= isValid(cur.left,
                               hasLowerBound,
                               lowerBound,
                               true,
                               Math.min(upperBound, cur.val));
            }
            else {
                ret &= isValid(cur.left,
                               hasLowerBound,
                               lowerBound,
                               true,
                               cur.val);
            }
        }
        if (cur.right != null) {
            if (hasLowerBound) {
                ret &= isValid(cur.right,
                               true,
                               Math.max(lowerBound, cur.val),
                               hasUpperBound,
                               upperBound);
            }
            else {
                ret &= isValid(cur.right,
                               true,
                               cur.val,
                               hasUpperBound,
                               upperBound);
            }
        }
        return ret;
    }
}