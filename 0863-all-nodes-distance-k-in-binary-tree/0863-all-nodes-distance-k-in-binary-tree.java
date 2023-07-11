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
    List<Integer> results;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        results = new ArrayList();
        dist(root, target, k, 0, 0);
        return results;
    }
    public int dist(TreeNode cur, TreeNode target, int k, int distFromAbove, int depth) {
        if (distFromAbove != 0) {
            if (distFromAbove == k) {
                results.add(cur.val);
            }
            else if (distFromAbove < k) {
                if (cur.left != null) {
                    dist(cur.left, target, k, distFromAbove+1, depth+1);
                }
                if (cur.right != null) {
                    dist(cur.right, target, k , distFromAbove+1, depth+1);
                }
            }
            return -1;
        }
        else {
            if (cur.val == target.val) {
                if (k == 0) {
                    results.add(cur.val);
                }
                if (cur.left != null) {
                    dist(cur.left, target, k, 1, depth+1);
                }
                if (cur.right != null) {
                    dist(cur.right, target, k, 1, depth+1);
                }
                return depth;
            }
            int leftDist = -1;
            if (cur.left != null) {
                leftDist = dist(cur.left, target, k, 0, depth+1);
            }
            int rightDist = -1;
            if (cur.right != null) {
                rightDist = dist(cur.right, target, k, 0, depth+1);
            }
            
            if (leftDist != -1) {
                leftDist -= depth;
                if (leftDist == k) {
                    results.add(cur.val);
                }
                else if (cur.right != null) {
                    rightDist = dist(cur.right, target, k, leftDist+1, depth+1);
                }
                return leftDist+depth;
            }
            else if (rightDist != -1) {
                rightDist -= depth;
                if (rightDist == k) {
                    results.add(cur.val);
                }
                else if (cur.left != null) {
                    leftDist = dist(cur.left, target, k, rightDist+1, depth+1);
                }
                return rightDist+depth;
            }
            else {
                return -1;
            }
        }
    }
}

/*
[0,1,null,null,2,null,3,null,4]
3
0
*/