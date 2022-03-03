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
    public List<Integer> getLonelyNodes(TreeNode root) {
        if (root.left == null
           && root.right == null) {
            return new ArrayList();
        }
        list = new ArrayList();
        recursive(root);
        return list;
    }
    
    public void recursive(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null
           && node.right != null) {
            list.add(node.right.val);
        }
        else if (node.left != null
                && node.right == null) {
            list.add(node.left.val);
        }
        
        recursive(node.left);
        recursive(node.right);    
    }
}