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
    HashMap<TreeNode, Long> sumMap;
    long sum;
    
    public int maxProduct(TreeNode root) {
        sumMap = new HashMap();
        sum = 0;
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            sum += cur.val;
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        getLowerSum(root);
        return (int) (maxProduct(root, 0) % 1_000_000_007);
    }
    
    public long getLowerSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (sumMap.containsKey(node) == false) {
            sumMap.put(node, node.val + getLowerSum(node.left) + getLowerSum(node.right));
        }
        return sumMap.get(node);
    }
    
    public long maxProduct(TreeNode node, int parent) {
        long ret = 0;
        if (node.left != null) {
            // node.left * node.right + parent
            ret = Math.max(ret, sumMap.get(node.left)*(sum-sumMap.get(node.left)));
            ret = Math.max(ret, maxProduct(node.left, parent+node.val));
        }
        if (node.right != null) {
            // node.right vs node.left + parent
            ret = Math.max(ret, sumMap.get(node.right)*(sum-sumMap.get(node.right)));
            ret = Math.max(ret, maxProduct(node.right, parent+node.val));
        }
        // System.out.println(String.format("node: %d, parent: %d, ret: %d", node.val, parent, ret));
        return ret;
    }
}