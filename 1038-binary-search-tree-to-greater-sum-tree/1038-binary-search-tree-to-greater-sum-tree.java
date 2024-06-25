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
    Map<TreeNode, Integer> map;
    List<Integer> li;
    int[] sum;
    public Solution() {
        map = new HashMap();
        li = new ArrayList();
    }
    public TreeNode bstToGst(TreeNode root) {
        buildList(root);
        sum = new int[li.size()+1];
        for (int i=li.size()-1; i>=0; i--) {
            sum[i] = sum[i+1]+li.get(i);
        }
        
        // System.out.println(Arrays.toString(sum));
        
        for (TreeNode key : map.keySet()) {
            key.val += sum[map.get(key)+1];
        }
        
        return root;
    }
    
    public void buildList(TreeNode node) {
        if (node == null) {
            return;
        }
        buildList(node.left);
        li.add(node.val);
        map.put(node, li.size()-1);
        buildList(node.right);
    }
}