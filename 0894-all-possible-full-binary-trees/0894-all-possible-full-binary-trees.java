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
    Map<Integer, List<TreeNode>> cache;
    public Solution() {
        cache = new HashMap();
        TreeNode node = new TreeNode(0);
        List<TreeNode> li = new ArrayList();
        li.add(node);
        cache.put(1, li);
    }
    public List<TreeNode> allPossibleFBT(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        List<TreeNode> result = new ArrayList();
        for (int left=1; left<n-1; left+=2) {
            List<TreeNode> lNodes = allPossibleFBT(left);
            List<TreeNode> rNodes = allPossibleFBT(n-1-left);
            for (TreeNode lNode : lNodes) {
                for (TreeNode rNode : rNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = lNode;
                    root.right = rNode;
                    result.add(root);
                }
            }
        }
        cache.put(n, result);
        return result;
    }
}