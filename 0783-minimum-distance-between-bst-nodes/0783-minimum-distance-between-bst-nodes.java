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
    List<Integer> li;
    public Solution() {
        li = new ArrayList();
    }
    public int minDiffInBST(TreeNode root) {
        buildList(root);
        int min = Integer.MAX_VALUE;
        for (int i=1; i<li.size(); i++) {
            min = Math.min(min, li.get(i)-li.get(i-1));
        }
        return min;
    }
    public void buildList(TreeNode node) {
        if (node == null) {
            return;
        }
        buildList(node.left);
        li.add(node.val);
        buildList(node.right);
    }
}
/*
[90,69,null,49,89,null,52]
*/