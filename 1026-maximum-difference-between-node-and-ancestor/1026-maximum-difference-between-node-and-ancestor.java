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
    public int maxAncestorDiff(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque();
        Queue<int[]> vq = new ArrayDeque();
        int[] minMax = new int[]{root.val, root.val};
        int ret = Integer.MIN_VALUE;
        q.add(root);
        vq.add(minMax);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            int[] v = vq.poll();
            if (cur == null) {
                continue;
            }
            ret = Math.max(ret, Math.max(Math.abs(v[0] - cur.val), Math.abs(v[1] - cur.val)));
            int min = Math.min(v[0], cur.val);
            int max = Math.max(v[1], cur.val);
            if (cur.left != null) {
                q.add(cur.left);
                vq.add(new int[]{min, max});
            }
            if (cur.right != null) {
                q.add(cur.right);
                vq.add(new int[]{min, max});   
            }
        }
        return ret;
    }
}