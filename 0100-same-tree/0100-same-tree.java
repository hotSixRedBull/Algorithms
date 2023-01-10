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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null
           && q == null) {
            return true;
        }
        if ((p == null
            && q != null)
            || (p != null
            && q == null)) {
            return false;
        }
        
        Queue<TreeNode> pq = new ArrayDeque();
        Queue<TreeNode> qq = new ArrayDeque();
        pq.offer(p);
        qq.offer(q);
        
        while (pq.size() > 0) {
            TreeNode pCur = pq.poll();
            TreeNode qCur = qq.poll();
            if (pCur.val != qCur.val) {
                return false;
            }
            if ((pCur.left == null
                && qCur.left != null)
               || (pCur.left != null
                && qCur.left == null)) {
                return false;
            }
            else if (pCur.left != null
                && qCur.left != null) {
                pq.offer(pCur.left);
                qq.offer(qCur.left);
            }
            if ((pCur.right == null
                && qCur.right != null)
               || (pCur.right != null
                && qCur.right == null)) {
                return false;
            }
            else if (pCur.right != null
                && qCur.right != null) {
                pq.offer(pCur.right);
                qq.offer(qCur.right);
            }
        }
        return true;
    }
}