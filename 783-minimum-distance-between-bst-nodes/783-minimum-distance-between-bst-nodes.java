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
    public int min;
    public ArrayList<Integer> list;
    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        this.list = new ArrayList<>();
        traverse(root);
        int smaller = this.list.get(0);
        for (int i=1; i<this.list.size(); i++) {
            int bigger = this.list.get(i);
            min = Math.min(min, bigger-smaller);
            smaller = bigger;
        }
        return min;
    }
    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        this.list.add(node.val);
        traverse(node.right);
    }
}