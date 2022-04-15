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
    static List<Integer> list;
    static int cur;
    public BSTIterator(TreeNode root) {
        cur = 0;
        list = new ArrayList();
        search(root);
    }
    
    private static void search(TreeNode node) {
        if (node == null) {
            return;
        }
        search(node.left);
        list.add(node.val);
        search(node.right);
    }
    
    public boolean hasNext() {
        return cur < list.size();
    }
    
    public int next() {
        return list.get(cur++);
    }
    
    public boolean hasPrev() {
        return cur > 1;
    }
    
    public int prev() {
        cur -= 2;
        return list.get(cur++);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */