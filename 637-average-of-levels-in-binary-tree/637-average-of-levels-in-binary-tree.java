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
    List<double[]> levelInfo;
    public List<Double> averageOfLevels(TreeNode root) {
        levelInfo = new ArrayList();
        levelInfo.add(new double[]{root.val, 1});
        calculateAverage(root.left, 1);
        calculateAverage(root.right, 1);
        List<Double> ans = new ArrayList();
        for (double[] each : levelInfo) {
            ans.add(each[0]/each[1]);
        }
        return ans;
    }
    public void calculateAverage(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (levelInfo.size() > level) {
            double[] saved = levelInfo.get(level);
            saved[0] += node.val;
            saved[1]++;
            levelInfo.set(level, saved);
        }
        else {
            levelInfo.add(new double[]{node.val, 1});
        }
        calculateAverage(node.left, level+1);
        calculateAverage(node.right, level+1);
    }
}