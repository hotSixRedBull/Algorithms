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
    public int sumRootToLeaf(TreeNode root) {
        return recursive(root, 0);
    }
    public int recursive(TreeNode cur, int value) {
        if (cur == null) {
            return 0;
        }
        // System.out.println(">>>"+cur.val);
        if (cur.left == null && cur.right == null) {
            // System.out.println(value+cur.val);
            return value+cur.val;
        }
        
        int curVal = cur.val;
        int ret = 0;
        ret += recursive(cur.left, (curVal+value)*2);
        ret += recursive(cur.right, (curVal+value)*2);
        return ret;
    }
}