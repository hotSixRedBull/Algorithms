class Unit {
    public TreeNode node;
    public long id;
    public int depth;
    public Unit(TreeNode n, long i, int d) {
        node = n;
        id = i;
        depth = d;
    }
}

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
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, long[]> map = new HashMap();
        Queue<Unit> q = new ArrayDeque();
        q.add(new Unit(root, 1, 0));
        long max = 0;
        while (q.size() > 0) {
            Unit cur = q.poll();
            if (map.containsKey(cur.depth) == false) {
                map.put(cur.depth, new long[]{cur.id, cur.id});    
            }
            long[] minMax = map.get(cur.depth);
            minMax[0] = Math.min(minMax[0], cur.id);
            minMax[1] = Math.max(minMax[1], cur.id);
            map.put(cur.depth, minMax);
            // System.out.println(Arrays.toString(minMax));
            max = Math.max(max, minMax[1]-minMax[0]+1);
            if (cur.node.left != null) {
                q.add(new Unit(cur.node.left, cur.id*2-1, cur.depth+1));
            }
            if (cur.node.right != null) {
                q.add(new Unit(cur.node.right, cur.id*2, cur.depth+1));
            }
        }
        return (int)max;
    }
}