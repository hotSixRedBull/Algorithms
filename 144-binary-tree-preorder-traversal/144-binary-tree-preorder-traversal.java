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
    List<Integer> list;
    public List<Integer> preorderTraversal(TreeNode root) {
        this.list = new ArrayList<Integer>();
        preorderRecursive(root);
        return this.list;
    }
    public void preorderRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        this.list.add(node.val);
        preorderRecursive(node.left);
        preorderRecursive(node.right);
    }
}