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
    public int pseudoPalindromicPaths (TreeNode root) {
        return countPP(root, new int[11]);
    }
    public int countPP(TreeNode cur, int[] cntMap) {
        if (cur == null) {
            return 0;
        }
        cntMap[cur.val]++;
        if (cur.left == null
           && cur.right == null) {
            int odd = 0;
            int even = 0;
            // System.out.println(Arrays.toString(cntMap));
            for (int i=1; i<10; i++) {
                if (cntMap[i] % 2 == 1) {
                    odd++;
                }
                else {
                    even++;
                }
            }
            if (odd <= 1) {
                return 1;
            }
            else {
                return 0;
            }
        }
        int count = 0;
        count += countPP(cur.left, Arrays.copyOf(cntMap, 11));
        count += countPP(cur.right, Arrays.copyOf(cntMap, 11));
        return count;
    }
}