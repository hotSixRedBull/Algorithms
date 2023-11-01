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
    public int[] findMode(TreeNode root) {
        int maxCnt = 0;
        Map<Integer, Set<Integer>> cntToVal = new HashMap();
        Map<Integer, Integer> valToCnt = new HashMap();
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            if (valToCnt.containsKey(cur.val)) {
                int cnt = valToCnt.get(cur.val);
                valToCnt.put(cur.val, cnt+1);
                cntToVal.get(cnt).remove(cur.val);
                cntToVal.putIfAbsent(cnt+1, new HashSet());
                cntToVal.get(cnt+1).add(cur.val);
                maxCnt = Math.max(maxCnt, cnt+1);
            }
            else {
                valToCnt.put(cur.val, 1);
                cntToVal.putIfAbsent(1, new HashSet());
                cntToVal.get(1).add(cur.val);
                maxCnt = Math.max(maxCnt, 1);
            }
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        
        int[] result = new int[cntToVal.get(maxCnt).size()];
        int index = 0;
        for (int val : cntToVal.get(maxCnt)) {
            result[index++] = val;
        }
        return result;
    }
}