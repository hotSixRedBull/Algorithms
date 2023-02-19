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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new ArrayDeque();
        Queue<TreeNode> nq = new ArrayDeque();
        List<Integer> curLevel = new ArrayList();
        q.add(root);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            curLevel.add(cur.val);
            if (cur.left != null) {
                nq.add(cur.left);
            }
            if (cur.right != null) {
                nq.add(cur.right);
            }
            if (q.size() == 0) {
                result.add(curLevel);
                curLevel = new ArrayList();
                q = nq;
                nq = new ArrayDeque();
            }
        }
        for (int i=1; i<result.size(); i+=2) {
            result.set(i, reverseList(result.get(i)));
        }
        return result;
    }
    public List<Integer> reverseList(List<Integer> li) {
        int lo = 0;
        int hi = li.size()-1;
        while (lo < hi) {
            int tmp = li.get(lo);
            li.set(lo, li.get(hi));
            li.set(hi, tmp);
            lo++;
            hi--;
        }
        return li;
    }
}