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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        int level = 0;
        while (q.size() > 0) {
            Queue<TreeNode> nextQ = new ArrayDeque();
            for (TreeNode cur : q) {
                if (ans.size() == level) {
                    ans.add(cur.val);
                }
                else {
                    ans.set(level, cur.val);
                }
                if (cur.left != null) {
                    nextQ.add(cur.left);
                }
                if (cur.right != null) {
                    nextQ.add(cur.right);
                }
            }
            q = nextQ;
            level++;
        }
        return ans;
    }
}