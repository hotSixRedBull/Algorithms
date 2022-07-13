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
        List<List<Integer>> orders = new ArrayList();
        if (root == null) {
            return orders;
        }
        List<TreeNode> li = new ArrayList();
        li.add(root);
        while (li.size() > 0) {
            List<Integer> level = new ArrayList();
            List<TreeNode> nli = new ArrayList();
            for (TreeNode cur : li) {
                level.add(cur.val);
                if (cur.left != null) {
                    nli.add(cur.left);
                }
                if (cur.right != null) {
                    nli.add(cur.right);
                }
            }
            orders.add(level);
            li = nli;
        }
        
        return orders;
    }
}