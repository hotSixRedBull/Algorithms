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
    public int longestZigZag(TreeNode root) {
        Map<TreeNode, Map<Boolean, Integer>> visit = new HashMap();
        Stack<TreeNode> stk = new Stack();
        Stack<Integer> depthStk = new Stack();
        Stack<Boolean> directionStk = new Stack();
        stk.add(root);
        stk.add(root);
        depthStk.add(0);
        depthStk.add(0);
        directionStk.add(true);
        directionStk.add(false);
        int max = 0;
        while(stk.size() > 0) {
            TreeNode cur = stk.pop();
            int depth = depthStk.pop();
            boolean isLeftChild = directionStk.pop();
            max = Math.max(max, depth);
            if(!isLeftChild) {
                if (cur.left != null) {
                        stk.add(cur.left);
                        depthStk.add(depth+1);
                        directionStk.add(true);
                }
                if (cur.right != null) {
                        stk.add(cur.right);
                        depthStk.add(0);
                        directionStk.add(true);
                }
            }
            if(isLeftChild) {
                if (cur.left != null) {
                        stk.add(cur.left);
                        depthStk.add(0);
                        directionStk.add(false);
                }
                if (cur.right != null) {
                        stk.add(cur.right);
                        depthStk.add(depth+1);
                        directionStk.add(false);
                }
            }
        }
        return max;
    }
}

/*
[1,null,1,1,1,null,null,null,1]
*/