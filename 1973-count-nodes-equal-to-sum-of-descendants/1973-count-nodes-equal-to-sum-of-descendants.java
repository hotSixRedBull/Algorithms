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
    Map<TreeNode, Integer> cache;
    int cnt;
    public Solution() {
        cache = new HashMap();
        cnt = 0;
    }
    public int equalToDescendants(TreeNode root) {
        cache = new HashMap();
        cnt = 0;
        recursive(root);
        return cnt;
    }
    public void recursive(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val == sum(node.left) + sum(node.right)) {
            cnt++;
        }
        recursive(node.left);
        recursive(node.right);
    }
    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        int result = node.val;
        result += sum(node.left);
        result += sum(node.right);
        cache.put(node, result);
        return result;
    }
    
}