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
    public boolean isCompleteTree(TreeNode root) {
        Map<Integer, Set<Integer>> map = new HashMap();
        Queue<TreeNode> q = new ArrayDeque();
        Queue<int[]> lq = new ArrayDeque();
        q.add(root);
        lq.add(new int[]{0, 1});
        map.put(0, new HashSet());
        map.get(0).add(1);
        while (q.size() > 0) {
           TreeNode cur = q.poll();
            int[] l = lq.poll();
            int level = l[0];
            int value = l[1];
            // System.out.println(String.format("%d,%d", level, value));
            if (cur.left != null) {
                if (map.containsKey(level+1) == false) {
                    if(value != 1) {
                       return false;
                    }
                  map.put(level+1, new HashSet());
                }
                if (value != 1 && map.get(level+1).contains(value*2-2) == false) {
                   return false;
                }
                map.get(level+1).add(value*2-1);
                q.add(cur.left);
                lq.add(new int[]{level+1, value*2-1});
            }
            if (cur.right != null) {
                 if (cur.left == null) {
                   return false;
                 }
                if (map.containsKey(level+1) == false 
                    || map.get(level+1).contains(value*2-1) == false) {
                    return false;
                }
                map.get(level+1).add(value*2);
                q.add(cur.right);
                lq.add(new int[]{level+1, value*2});
            }
        }
        
        // System.out.println(map);
        int size = 1;
        for (int i=0; i<map.size()-1; i++) {
           if (map.containsKey(i) == false || map.get(i).size() != size) {
            return false;
          }
            size *= 2;
        }
        return true;
    }
}

/*
[1,2,3,4,5,6]
[1]
[1,2,3,null]
[1,2,null,4]
[1,2]
[1,null,2]
*/