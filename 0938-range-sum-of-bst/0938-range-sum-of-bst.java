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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null
           || low > high) {
            return 0;
        }
        int ret = 0;
        if (low <= root.val
           && root.val <= high) {
            // System.out.println(String.format("low: %d, high: %d, root.val: %d", low, high, root.val));
            ret += root.val;
        }
        if (root.val > low) {
            if (high > root.val) {
                ret += rangeSumBST(root.left, low, root.val);
            }
            else {
                ret += rangeSumBST(root.left, low, high);
            }
        }
        if (root.val < high) {
            if (root.val > low) {
                ret += rangeSumBST(root.right, root.val, high);
            }
            else {
                ret += rangeSumBST(root.right, low, high);
            }
        }
        return ret;
    }
}