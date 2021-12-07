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
    public int findSecondMinimumValue(TreeNode root) {
        int smallest = root.val;
        int answer = -1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            if (cur.left != null) {
                if (cur.left.val == smallest) {
                    q.add(cur.left);
                }
                if (cur.left.val > smallest) {
                    answer = answer < 0 ? cur.left.val : Math.min(answer, cur.left.val);
                }
            }
            if (cur.right != null) {
                if (cur.right.val == smallest) {
                    q.add(cur.right);
                }
                if (cur.right.val > smallest) {
                    answer = answer < 0 ? cur.right.val : Math.min(answer, cur.right.val);
                }
            }
        }
        if (answer < 0) {
            return -1;
        }
        else {
            return answer;
        }
    }
}