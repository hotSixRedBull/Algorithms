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
    Queue<TreeNode[]> q;
    public Solution() {
        q = new ArrayDeque();
    }
    public boolean isSymmetric(TreeNode root) {
        int rootResult = addNode(root.left, root.right);
        if (rootResult == 1) {
            return true;
        }
        if (rootResult == -1) {
            return false;
        }
        
        while(q.size() > 0) {
            TreeNode[] pair = q.poll();
            if (pair[0].val != pair[1].val) {
                return false;
            }
            if (addNode(pair[0].left, pair[1].right) == -1) {
                return false;
            }
            if (addNode(pair[1].left, pair[0].right) == -1) {
                return false;
            }
        }
        
        return true;
    }
    public int addNode(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return 1;
        }
        if ((left == null && right != null)
           || (left != null && right == null)) {
            return -1;
        }
        q.add(new TreeNode[]{left, right});
        return 0;
    }
}