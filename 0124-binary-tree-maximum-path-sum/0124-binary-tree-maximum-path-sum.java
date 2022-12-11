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
    HashMap<TreeNode, Integer> maxMap;
    public Solution() {
        maxMap = new HashMap();
    }
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        getMaxLeafPath(root);
        return maxPathSumSub(root);
    }
    
    public int getMaxLeafPath(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (maxMap.containsKey(node)) {
            return maxMap.get(node);
        }
        int max = 0;
        max = Math.max(max, getMaxLeafPath(node.left));
        max = Math.max(max, getMaxLeafPath(node.right));
        maxMap.put(node, max + node.val);
        return max + node.val;
    }
    
    public int maxPathSumSub(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int ret = node.val;
        ret = Math.max(ret, node.val + maxMap.getOrDefault(node.left, 0));
        ret = Math.max(ret, node.val + maxMap.getOrDefault(node.right, 0));
        ret = Math.max(ret, node.val + maxMap.getOrDefault(node.left, 0) + maxMap.getOrDefault(node.right, 0));
        ret = Math.max(ret, maxPathSumSub(node.left));
        ret = Math.max(ret, maxPathSumSub(node.right));
        return ret;
    }
}

/*
3 cases
1. containing root
2. not containing root - only contains subset of left subtree
3. not containing root - only contains subset of right subtree


[-3]
[1,2]
[2,-1]
*/