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
    public boolean findTarget(TreeNode root, int k) {
        return findTwo(root, root, k);
    }
    public boolean findTwo(TreeNode node, TreeNode root, int k) {
        if (node == null) {
            return false;
        }
        int rest = k-node.val;
        boolean found = false;
        if (rest != node.val) {
            found |= findOne(root, rest);
        }
        found |= findTwo(node.left, root, k);
        found |= findTwo(node.right, root, k);
        return found;
    }
    public boolean findOne(TreeNode node, int k) {
        if (node == null) {
            return false;
        }
        if (node.val == k) {
            return true;
        }
        else if (node.val < k) {
            return findOne(node.right, k);
        }
        else {
            return findOne(node.left, k);
        }
    }
}