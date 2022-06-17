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
        //Make p < q
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if (root == p
           || root == q) {
            return root;
        }
        boolean leftP = find(root.left, p);
        boolean rightQ = find(root.right, q);
        if (leftP) {
            boolean leftQ = find(root.left, q);
            if (rightQ) {
                return root;
            }
            else {
                return lowestCommonAncestor(root.left, p, q);
            }
        }
        boolean rightP = find(root.right, p);
        if (rightP && rightQ) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
    public boolean find(TreeNode root, TreeNode k) {
        if (root == null) {
            return false;
        }
        else if (root.val == k.val) {
            return true;
        }
        else if (root.val < k.val) {
            return find(root.right, k);
        }
        else {
            return find(root.left, k);
        }
    }
}