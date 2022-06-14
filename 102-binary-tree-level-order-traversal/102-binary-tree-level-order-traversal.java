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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new ArrayDeque();
        List<Integer> level = new ArrayList();
        q.add(root);
        q.add(new TreeNode(-1001));
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            if (cur.val == -1001) {
                if (q.size() > 0) {
                    q.add(new TreeNode(-1001));
                    ans.add(new ArrayList(level));
                    level.clear();
                }
                continue;
            }
            level.add(cur.val);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        if (level.size() > 0) {
            ans.add(level);
        }
        return ans;
    }
}