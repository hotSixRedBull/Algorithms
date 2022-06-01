/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        PriorityQueue<TreeNode> pq = new PriorityQueue(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode a, TreeNode b) {
                return b.val-a.val;
            }
        });
        return inorderSuccessorRecursive(root, p, pq);
    }
    
    public TreeNode inorderSuccessorRecursive(TreeNode cur, TreeNode find, PriorityQueue<TreeNode> pq) {
        if (cur.val == find.val) {
            if (cur.right != null) {
                return findLeftMostChild(cur.right);
            }
            else {
                //find parent
                if (pq.size() == 0) {
                    return null;
                }
                TreeNode candidate = null;
                while (pq.size() > 0
                       && pq.peek().val > find.val) {
                    candidate = pq.poll();
                }
                return candidate;
            }
        }
        else if (cur.val < find.val) {
            if (cur.right == null) {
                return null;
            }
            pq.add(cur);
            return inorderSuccessorRecursive(cur.right, find, pq);
        }
        else {
            if (cur.left == null) {
                return null;
            }
            pq.add(cur);
            return inorderSuccessorRecursive(cur.left, find, pq);
        }
    }
    
    public TreeNode findLeftMostChild(TreeNode node) {
        if (node.left != null) {
            return findLeftMostChild(node.left);
        }
        else {
            return node;
        }
    }
    
}