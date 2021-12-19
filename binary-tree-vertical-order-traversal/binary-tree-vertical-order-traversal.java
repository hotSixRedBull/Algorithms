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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<Integer> posQ = new ArrayDeque<>();
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        if (root != null) {
            q.add(root);
            posQ.add(0);
        }
        
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            int pos = posQ.poll();
                
            List<Integer> tmp = treeMap.containsKey(pos) ? treeMap.get(pos) : new ArrayList<>();
            tmp.add(cur.val);
            treeMap.put(pos, tmp);
            
            if (cur.left != null) {
                q.add(cur.left);
                posQ.add(pos-1);
            }
            if (cur.right != null) {
                q.add(cur.right);
                posQ.add(pos+1);
            }
        }
        //System.out.println(treeMap);
        return new ArrayList<>(treeMap.values());
    }
}