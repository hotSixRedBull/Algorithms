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
    List<TreeNode> list;
    List<Integer> intList;
    public void recoverTree(TreeNode root) {
        list = new ArrayList();
        intList = new ArrayList();
        
        buildList(root);
        Collections.sort(intList);
        
        // System.out.println(intList);
        
        for (int i=0; i<list.size(); i++) {
            list.get(i).val = intList.get(i);
        }
    }
    public void buildList(TreeNode node) {
        if (node == null) {
            return;
        }
        buildList(node.left);
        list.add(node);
        intList.add(node.val);
        buildList(node.right);
    }
}