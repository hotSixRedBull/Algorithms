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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        Stack<List<String>> paths = new Stack<>();
        stk.push(root);
        paths.push(new ArrayList<>());
        while (stk.size() > 0) {
            TreeNode cur = stk.pop();
            List<String> list = paths.pop();
            list.add(String.valueOf(cur.val));
            if (cur.left == null && cur.right == null) {
                String ansCandidate = (list.size() == 0) ? "" : list.get(0);
                for(int i=1; i<list.size(); i++) {
                    ansCandidate += "->"+String.valueOf(list.get(i));
                }
                ans.add(ansCandidate);
            }
            else {
                if (cur.left != null) {
                    stk.push(cur.left);
                    paths.push(new ArrayList<>(list));
                }
                if (cur.right != null) {
                    stk.push(cur.right);
                    paths.push(new ArrayList<>(list));
                }
            }
        }
        return ans;
    }
}