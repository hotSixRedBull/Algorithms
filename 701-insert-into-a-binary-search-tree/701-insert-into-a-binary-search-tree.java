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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        recursive(root, val);
        return root;
    }
    public void recursive(TreeNode node, int val) {
        if (node.val < val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
            }
            else {
                recursive(node.right, val);
            }
        }
        else {
            if (node.left == null) {
                node.left = new TreeNode(val);
            }
            else {
                recursive(node.left, val);
            }
        }
    }
}