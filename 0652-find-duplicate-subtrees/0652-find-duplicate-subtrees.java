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
    HashSet<String> cache;
    HashSet<String> used;
    List<TreeNode> answer;
    public Solution() {
        cache = new HashSet();
        used = new HashSet();
        answer = new ArrayList();
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return null;
        }
        String inOrder = inOrderString(root);
        String preOrder = preOrderString(root);
        String key = String.format("%s#%s", inOrder, preOrder);
        // System.out.println(key);
        if (cache.contains(key)
           && !used.contains(key)) {
            used.add(key);
            answer.add(root);
        }
        cache.add(key);
        findDuplicateSubtrees(root.left);
        findDuplicateSubtrees(root.right);
        return answer;
    }
    public String inOrderString(TreeNode node) {
        String result = "";
        if (node == null) {
            return result;
        }
        return inOrderString(node.left)+","+node.val+","+inOrderString(node.right);
    }
    public String preOrderString(TreeNode node) {
        String result = "";
        if (node == null) {
            return result+"null";
        }
        return node.val+","+preOrderString(node.left)+","+preOrderString(node.right);
    }
}

/*
[0,0,0,0,null,null,0,null,null,null,0]
[2,1,11,11,null,1]
*/