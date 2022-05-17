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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q = new ArrayDeque();
        Queue<TreeNode> cq = new ArrayDeque();
        q.add(original);
        cq.add(cloned);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            TreeNode clone = cq.poll();
            if (cur == target) {
                return clone;
            }
            if (cur.left != null) {
                q.add(cur.left);
                cq.add(clone.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
                cq.add(clone.right);
            }
        }
        return null;
    }
}