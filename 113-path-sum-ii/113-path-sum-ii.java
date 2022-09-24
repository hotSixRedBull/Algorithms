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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList();
        if (root == null) {
            return answer;
        }
        Queue<TreeNode> q = new ArrayDeque();
        Queue<Integer> sums = new ArrayDeque();
        Queue<List<Integer>> paths = new ArrayDeque();
        q.offer(root);
        sums.offer(root.val);
        paths.offer(new ArrayList(List.of(root.val)));
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            int sum = sums.poll();
            List<Integer> path = paths.poll();
            if (cur.left == null
               && cur.right == null) {
                if (sum == targetSum) {
                    answer.add(path);
                }
                continue;
            }
            if (cur.left != null) {
                q.offer(cur.left);
                sums.offer(sum+cur.left.val);
                List<Integer> newPath = new ArrayList(path);
                newPath.add(cur.left.val);
                paths.offer(newPath);
            }
            if (cur.right != null) {
                q.offer(cur.right);
                sums.offer(sum+cur.right.val);
                List<Integer> newPath = new ArrayList(path);
                newPath.add(cur.right.val);
                paths.offer(newPath);
            }
        }
        return answer;
    }
}