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
class Pair<firstThing, secondThing>{
	firstThing y;
	secondThing x;
	public Pair(firstThing y, secondThing x) {
		this.y = y;
		this.x = x;
	}
	public firstThing first() {
		return y;
	}
	public secondThing second() {
		return x;
	}
}


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<Pair<TreeNode, Integer>>();
        if (root == null) {
            return false;
        }
        q.add(new Pair(root, root.val));
        while (q.size() > 0) {
            Pair<TreeNode, Integer> cur = q.poll();
            TreeNode curNode = cur.first();
            if (curNode.left == null && curNode.right == null && cur.second() == targetSum) {
                return true;
            }
            if (curNode.left != null) {
                q.add(new Pair(curNode.left, cur.second()+curNode.left.val));
            }
            if (curNode.right != null) {
                q.add(new Pair(curNode.right, cur.second()+curNode.right.val));
            }
        }
        return false;
    }
}