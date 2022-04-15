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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode sentinel = new TreeNode();
        sentinel.right = root;
        sentinel.right = trim(root, low, high);
        return sentinel.right;
    }
    
    public TreeNode trim(TreeNode node, int lo, int hi) {
        if (node == null) {
            return null;
        }
        else if (node.val < lo) {
            return trim(node.right, lo, hi);
        }
        else if (node.val > hi) {
            return trim(node.left, lo, hi);
        }
        node.left = trim(node.left, lo, hi);
        node.right = trim(node.right, lo, hi);
        return node;
    }
}