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
    List<Integer> list;
    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList();
        buildList(root);
        TreeNode sentinel = new TreeNode();
        TreeNode cur = sentinel;
        for (Integer node : list) {
            cur.right = new TreeNode(node);
            cur = cur.right;
        }
        return sentinel.right;
    }
    public void buildList(TreeNode node) {
        if (node == null) {
            return;
        }
        buildList(node.left);
        list.add(node.val);
        buildList(node.right);
    }
}
/*
1. inorder로 탐색하고, 그대로 이어주기
- N/N
2. in-place
- N/1
- 내 생각엔 morris traversal을 쓸 것 같은데..
- 구현하진 못하겠다.
*/