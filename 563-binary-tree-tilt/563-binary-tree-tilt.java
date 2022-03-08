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
    private int sum = 0;
    private HashMap<TreeNode, Integer> map = new HashMap();
    public int findTilt(TreeNode root) {
        if (root == null
           || (root.left == null
              && root.right == null)) {
            return 0;
        }
        int left = recursiveSum(root.left);
        int right = recursiveSum(root.right);
        // System.out.println("sum: "+sum);
        sum += Math.abs(left-right);
        return sum;
    }
    
    public int recursiveSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = recursiveSum(node.left);
        int right = recursiveSum(node.right);
        sum += Math.abs(left-right);
        // System.out.println(String.format("cur: %d, left: %d, right: %d, sum: %d", node.val, left, right, sum));
        if (map.containsKey(node)) {
            return map.get(node);
        }
        map.put(node, node.val + left + right);
        return map.get(node);
    }
}