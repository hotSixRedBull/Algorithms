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
    TreeNode sentinel;
    TreeNode cur;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        sentinel = new TreeNode();
        cur = sentinel;
        preorder(root);
        root.val = sentinel.right.val;
        root.left = null;
        root.right = sentinel.right.right;
    }
    public void preorder(TreeNode c) {
        if (c == null) {
            return;
        }
        cur.right = new TreeNode(c.val);
        // System.out.println(cur.right.val);
        cur = cur.right;
        preorder(c.left);
        preorder(c.right);
    }
}