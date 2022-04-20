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
class BSTIterator {
    List<Integer> list;
    int pos;
    public BSTIterator(TreeNode root) {
        list = new ArrayList();
        pos = 0;
        recursive(root);   
    }
    
    private void recursive(TreeNode node) {
        if (node == null) {
            return;
        }
        recursive(node.left);
        list.add(node.val);
        recursive(node.right);
    }
    
    public int next() {
        return list.get(pos++);
    }
    
    public boolean hasNext() {
        return pos < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */