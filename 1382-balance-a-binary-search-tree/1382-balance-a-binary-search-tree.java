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
    List<Integer> li;
    
    public Solution() {
        li = new ArrayList();
    }
    
    public TreeNode balanceBST(TreeNode root) {
        buildList(root);
        return buildNewTree(0, li.size()-1);
    }
    
    public void buildList(TreeNode node) {
        if (node == null) {
            return;
        }
        
        buildList(node.left);
        li.add(node.val);
        buildList(node.right);
    }
    
    public TreeNode buildNewTree(int left, int right) {
        int index = (left+right)/2;
        if (index < 0 || index >= li.size()) {
            return null;
        }
        TreeNode cur = new TreeNode(li.get(index));
        if (index > 0 && index > left) {
            cur.left = buildNewTree(left, index-1);
        }
        if (index < li.size() && index < right) {
            cur.right = buildNewTree(index+1, right);
        }
        return cur;
    }
}