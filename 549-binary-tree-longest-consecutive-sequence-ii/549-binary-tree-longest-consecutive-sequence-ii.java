//problem description is somewhat wrong.
//do not solve this problem again.
public class Solution {
    int maxval = 0;
    
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxval;
    }
    
    public int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[] {0,0};
        }
        
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] left = longestPath(root.left);
            if (root.val == root.left.val + 1) {
                dcr = left[1] + 1;
            } else if (root.val == root.left.val - 1) {
                inr = left[0] + 1;
            }
        }
        
        if (root.right != null) {
            int[] right = longestPath(root.right);
            if (root.val == root.right.val + 1) {
                dcr = Math.max(dcr, right[1] + 1);
            } else if (root.val == root.right.val - 1) {
                inr = Math.max(inr, right[0] + 1);
            }
        }
        
        maxval = Math.max(maxval, dcr + inr - 1);
        return new int[] {inr, dcr};
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

/*
class Solution {
    HashMap<TreeNode, Integer> cache;
    public Solution() {
        cache = new HashMap();
    }
    public int longestConsecutive(TreeNode root) {
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        if (root == null) {
            return 0;
        }
        int left = longestConsecutive(root.left);
        int right = longestConsecutive(root.right);
        int includeCur = 1;
        if (root.left != null) {
            if (Math.abs(root.left.val-root.val) == 1) {
                Queue<TreeNode> q = new ArrayDeque();
                Queue<Integer> lenQ = new ArrayDeque();
                q.add(root.left);
                lenQ.add(1);
                int maxLen = 1;
                while (q.size() > 0) {
                    TreeNode cur = q.poll();
                    int len = lenQ.poll();
                    maxLen = Math.max(maxLen, len);
                    if (cur.left != null
                       && Math.abs(cur.left.val-cur.val) == 1) {
                        q.add(cur.left);
                        lenQ.add(len+1);
                    }
                    if (cur.right != null
                       && Math.abs(cur.right.val-cur.val) == 1) {
                        q.add(cur.right);
                        lenQ.add(len+1);
                    }
                }
                includeCur += maxLen;
            }
        }
        if (root.right != null) {
            if (Math.abs(root.right.val-root.val) == 1) {
                Queue<TreeNode> q = new ArrayDeque();
                Queue<Integer> lenQ = new ArrayDeque();
                q.add(root.right);
                lenQ.add(1);
                int maxLen = 1;
                while (q.size() > 0) {
                    TreeNode cur = q.poll();
                    int len = lenQ.poll();
                    maxLen = Math.max(maxLen, len);
                    if (cur.left != null
                       && Math.abs(cur.left.val-cur.val) == 1) {
                        q.add(cur.left);
                        lenQ.add(len+1);
                    }
                    if (cur.right != null
                       && Math.abs(cur.right.val-cur.val) == 1) {
                        q.add(cur.right);
                        lenQ.add(len+1);
                    }
                }
                includeCur += maxLen;
            }
        }
        int max = Math.max(left, Math.max(includeCur, right));
        cache.put(root, max);
        return max;
    }
}
*/
/*
current node is included.
current node is not included.
    - left nodes are only
    - right nodes are only
*/