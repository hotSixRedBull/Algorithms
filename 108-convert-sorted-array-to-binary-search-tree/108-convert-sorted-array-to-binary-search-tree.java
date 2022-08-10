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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(nums[nums.length/2]);
        makeTree(root, true, nums, 0, nums.length/2-1);
        makeTree(root, false, nums, nums.length/2+1, nums.length-1);
        return root;
    }
    public void makeTree(TreeNode parent, boolean isLeft, int[] nums, int left, int right) {
        // System.out.println(String.format("left: %d, right: %d, nums.length: %d", left, right, nums.length));
        if (left > right) {
            return;
        }
        if (left == right) {
            if (isLeft) {
                parent.left = new TreeNode(nums[left]);
            }
            else {
                parent.right = new TreeNode(nums[right]);
            }
            return;
        }
        int pos = (right + left)/2;
        TreeNode child = new TreeNode(nums[pos]);
        if (isLeft) {
            parent.left = child;
        }
        else {
            parent.right = child;
        }
        makeTree(child, true, nums, left, pos-1);
        makeTree(child, false, nums, pos+1, right);
    }
}