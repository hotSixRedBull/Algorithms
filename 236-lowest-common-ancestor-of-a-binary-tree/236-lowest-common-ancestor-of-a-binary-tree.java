/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p) {
            boolean left = find(root.left, q);
            boolean right = find(root.right, q);
            if (left || right) {
                return root;
            }
            else {
                return null;
            }
        }
        else if (root == q) {
            boolean left = find(root.left, p);
            boolean right = find(root.right, p);
            if (left || right) {
                return root;
            }
            else {
                return null;
            }
        }
        else {
            boolean leftP = find(root.left, p);
            boolean rightP = find(root.right, p);
            boolean leftQ = find(root.left, q);
            boolean rightQ = find(root.right, q);
            if ((leftP && rightQ) || (leftQ && rightP)) {
                return root;
            }
            if (leftP && leftQ) {
                return lowestCommonAncestor(root.left, p, q);
            }
            else if (rightP && rightQ) {
                return lowestCommonAncestor(root.right, p, q);
            }
            else {
                return null;
            }
        }
    }
    public boolean find(TreeNode cur, TreeNode target) {
        if (cur == null) {
            return false;
        }
        if (cur.val == target.val) {
            return true;
        }
        return find(cur.left, target) || find(cur.right, target);
    }
}