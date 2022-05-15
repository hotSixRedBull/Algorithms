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
    public int deepestLeavesSum(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque();
        ArrayDeque<TreeNode> nextQ = new ArrayDeque();
        q.add(root);
        int sum = 0;
        do {
            sum = 0;
            nextQ.clear();
            while (q.size() > 0) {
                TreeNode cur = q.poll();
                if (cur.left == null
                   && cur.right == null) {
                    sum += cur.val;
                }
                if (cur.left != null) {
                    nextQ.add(cur.left);
                }
                if (cur.right != null) {
                    nextQ.add(cur.right);
                }
            }
            q = nextQ.clone();
        } while(q.size() > 0);
        return sum;
    }
}