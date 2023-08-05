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
    List<TreeNode> result;
    Set<String> set;
    public List<TreeNode> generateTrees(int n) {
        result = new ArrayList();
        set = new HashSet();
        permutation(0, new boolean[n+1], n, new int[n]);
        return result;
    }
    public void permutation(int cur, boolean[] used, int n, int[] built) {
        if (cur == n) {
            TreeNode newRoot = build_bst(built);
            String pre = preOrder(newRoot);
            if (set.contains(pre) == false) {
                set.add(pre);
                result.add(newRoot);    
            }
            return;
        }
        for (int i=1; i<=n; i++) {
            if (used[i] == false) {
                used[i] = true;
                built[cur] = i;
                permutation(cur+1, used, n, built);
                used[i] = false;
            }
        }
    }
    public TreeNode build_bst(int[] arr) {
        // System.out.println(Arrays.toString(arr));
        TreeNode root = new TreeNode(arr[0]);
        for (int i=1; i<arr.length; i++) {
            TreeNode cur = root;
            while (true) {
                if (cur.val < arr[i]) {
                    if (cur.right == null) {
                        cur.right = new TreeNode(arr[i]);
                        break;
                    }
                    cur = cur.right;
                }
                else {
                    if (cur.left == null) {
                        cur.left = new TreeNode(arr[i]);
                        break;
                    }
                    cur = cur.left;
                }
            }
        }
        return root;
    }
    public String preOrder(TreeNode node) {
        if (node == null) {
            return "";
        }
        return String.valueOf(node.val) + preOrder(node.left) + preOrder(node.right);
    }
}