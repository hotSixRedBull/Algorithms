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
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int maxLevel = 1;
        Queue<TreeNode> q = new ArrayDeque();
        Queue<TreeNode> nq = new ArrayDeque();
        q.add(root);
        int curLevel = 1;
        int curLevelSum = 0;
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            curLevelSum += cur.val;
            if (cur.left != null) {
                nq.add(cur.left);
            }
            if (cur.right != null) {
                nq.add(cur.right);
            }
            if (q.size() == 0) {
                if (max < curLevelSum) {
                    max = curLevelSum;
                    maxLevel = curLevel;
                }
                curLevel++;
                curLevelSum = 0;
                q = nq;
                nq = new ArrayDeque();
            }
        }
        return maxLevel;
    }
}

/*
[-100,-200,-300,-20,-5,-10,null]
*/