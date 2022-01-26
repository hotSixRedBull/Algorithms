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
    List<Integer> list1;
    List<Integer> list2;
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        
        recursive1(root1);
        recursive2(root2);
        
        int index1 = 0;
        int index2 = 0;
        List<Integer> ans = new ArrayList<>();
        while (index1 < list1.size() && index2 < list2.size()) {
            int a = list1.get(index1);
            int b = list2.get(index2);
            if (a < b) {
                ans.add(a);
                index1++;
            }
            else {
                ans.add(b);
                index2++;
            }
            // System.out.println(ans);
        }
        
        while (index1 < list1.size()) {
            ans.add(list1.get(index1));
            index1++;
        }
        
        while (index2 < list2.size()) {
            ans.add(list2.get(index2));
            index2++;
        }
        
        return ans;
    }
    
    public void recursive1(TreeNode node) {
        if (node == null) {
            return;
        }
        recursive1(node.left);
        list1.add(node.val);
        recursive1(node.right);
    }
    
    public void recursive2(TreeNode node) {
        if (node == null) {
            return;
        }
        recursive2(node.left);
        list2.add(node.val);
        recursive2(node.right);
    }
    
}