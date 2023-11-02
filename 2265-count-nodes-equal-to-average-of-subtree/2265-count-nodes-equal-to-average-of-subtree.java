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
    int cnt;
    public int averageOfSubtree(TreeNode root) {
        cnt = 0;
        getSubtreeSum(root);
        return cnt;
    }
    public int[] getSubtreeSum(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        if (node.left == null && node.right == null) {
            cnt++;
            return new int[]{1, node.val};
        }
        int[] left = getSubtreeSum(node.left);
        int[] right = getSubtreeSum(node.right);
        int sum = left[1]+right[1]+node.val;
        int nodeCnt = left[0]+right[0]+1;
        int average = (int)Math.floor((sum)/(nodeCnt));
        if (average == node.val) {
            cnt++;
        }
        return new int[]{nodeCnt, sum};
    }
}