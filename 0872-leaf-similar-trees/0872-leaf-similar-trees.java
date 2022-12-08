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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> leafs = new ArrayDeque();
        
        Stack<TreeNode> stk = new Stack();
        stk.add(root1);
        while (stk.size() > 0) {
            TreeNode cur = stk.pop();
            if (cur == null) {
                continue;
            }
            if (cur.left == null
               && cur.right == null) {
                leafs.add(cur.val);
                continue;
            }
            stk.add(cur.left);
            stk.add(cur.right);
        }
        // System.out.println(leafs);
        stk.add(root2);
        while (stk.size() > 0) {
            TreeNode cur = stk.pop();
            if (cur == null) {
                continue;
            }
            if (cur.left == null
               && cur.right == null) {
                if (leafs.size() == 0
                    || leafs.peek() != cur.val) {
                    return false;
                }
                leafs.poll();
                continue;
            }
            stk.add(cur.left);
            stk.add(cur.right);
        }
        
        return leafs.size() == 0;
        
    }
}