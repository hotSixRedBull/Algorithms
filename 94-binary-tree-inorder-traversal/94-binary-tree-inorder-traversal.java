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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        inOrder(ans, root);
        return ans;
    }
    public void inOrder(List<Integer> li, TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(li, node.left);
        li.add(node.val);
        inOrder(li, node.right);
    }
}