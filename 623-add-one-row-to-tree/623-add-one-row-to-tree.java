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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        int curDepth = 1;
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        while (curDepth < depth) {
            curDepth++;
            Queue<TreeNode> next = new ArrayDeque();
            while (q.size() > 0) {
                TreeNode cur = q.poll();
                if (curDepth == depth) {
                    TreeNode newLeft = new TreeNode(val);
                    TreeNode newRight = new TreeNode(val);
                    newLeft.left = cur.left;
                    newRight.right = cur.right;
                    cur.left = newLeft;
                    cur.right = newRight;
                }
                if (cur.left != null) {
                    next.add(cur.left);
                }
                if (cur.right != null) {
                    next.add(cur.right);
                }
            }
            q = next;
        }
        return root;
    }
}