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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> answer = new ArrayList();
        while (root.left != null
              || root.right != null) {
            List<Integer> list = new ArrayList();
            Queue<TreeNode> parentQ = new ArrayDeque();
            Queue<TreeNode> q = new ArrayDeque();
            parentQ.add(new TreeNode());
            q.add(root);

            while (q.size() > 0) {
                TreeNode parent = parentQ.poll();
                TreeNode cur = q.poll();
                if (cur.left == null
                   && cur.right == null) {
                    list.add(cur.val);
                    if (parent != null) {
                        if (parent.left == cur) {
                            parent.left = null;
                        }
                        else {
                            parent.right = null;
                        }
                    }
                    continue;
                }
                if (cur.left != null) {
                    parentQ.add(cur);
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    parentQ.add(cur);
                    q.add(cur.right);
                }
            }
            answer.add(list);
        }
        answer.add(new ArrayList(List.of(root.val)));
        
        return answer;
    }
}