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
    Map<TreeNode, Map<Integer, Boolean>> cache;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        cache = new HashMap();
        int uni = 0;
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            // System.out.println(String.format(">> cur: %s, cur.val: %d", cur, cur.val));
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
            if (hasAll(cur, cur.val)) {
                uni++;
                // System.out.println(String.format("uni: %d", uni));
            }
        }
        return uni;
    }
    
    public boolean hasAll(TreeNode cur, int val) {
        if (cur == null) {
            return true;
        }
        
        if (cache.containsKey(cur)
           && cache.get(cur).containsKey(val)) {
            return cache.get(cur).get(val);
        }
        
        if (cur.val != val) {
            return false;
        }
        
        boolean result = hasAll(cur.left, val) && hasAll(cur.right, val);
        cache.putIfAbsent(cur, new HashMap());
        cache.get(cur).put(val, result);
        // System.out.println(String.format("hasAll(%s,%d) result: %s", cur,val, result));
        return result;
    }
}