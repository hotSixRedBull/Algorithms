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
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> q = new ArrayDeque<>();
        HashMap<Integer, Integer> intMap = new HashMap<>();
        q.add(root);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            if (intMap.containsKey(k-cur.val)) {
                if ((k-cur.val == cur.val && intMap.get(cur.val) > 1) || k-cur.val != cur.val) {
                    return true;
                }
            }
            intMap.put(cur.val, intMap.getOrDefault(cur.val, 0)+1);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        return false;
    }
}