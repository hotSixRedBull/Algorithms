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
    TreeMap<Integer, List<int[]>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new TreeMap();
        preOrder(root, 0, 0);
        
        List<List<Integer>> ans = new ArrayList();
        for (int key : map.keySet()) {
            List<int[]> li = map.get(key);
            Collections.sort(li, new Comparator<int[]>() {
                @Override
               public int compare(int[] a, int[] b) {
                   return a[1] - b[1];
               } 
            });
            List<Integer> eachList = new ArrayList();
            for (int[] element : li) {
                eachList.add(element[0]);
            }
            ans.add(eachList);
        }
        return ans;
    }
    
    public void preOrder(TreeNode node, int pos, int depth) {
        if (node == null) {
            return;
        }
        if (map.containsKey(pos) == false) {
            map.put(pos, new ArrayList());
        }
        map.get(pos).add(new int[]{node.val, depth});
        preOrder(node.left, pos-1, depth+1);
        preOrder(node.right, pos+1, depth+1);
    }
}