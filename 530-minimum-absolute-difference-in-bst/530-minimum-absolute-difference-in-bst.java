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
    private List<Integer> list;
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        list = new ArrayList();
        recursive(root);
        for (int i=1; i<list.size(); i++) {
            min = Math.min(min, list.get(i)-list.get(i-1));
        }
        return min;
    }
    public void recursive(TreeNode node) {
        if (node == null) {
            return;
        }
        recursive(node.left);
        list.add(node.val);
        recursive(node.right);
    }
}