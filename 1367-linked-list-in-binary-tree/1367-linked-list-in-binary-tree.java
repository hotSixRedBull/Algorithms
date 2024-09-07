/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    Map<Integer, List<TreeNode>> map;
    public boolean isSubPath(ListNode head, TreeNode root) {
        map = new HashMap();
        search(root);
        Stack<TreeNode> tStk = new Stack();
        Stack<ListNode> lStk = new Stack(); 
        for (TreeNode node : map.get(head.val)) {
            tStk.push(node);
            lStk.push(head);
        }
        while (tStk.size() > 0) {
            TreeNode t = tStk.pop();
            ListNode l = lStk.pop();
            if (l.next == null) {
                return true;
            }
            if (t.left != null
               && t.left.val == l.next.val) {
                tStk.push(t.left);
                lStk.push(l.next);
            }
            if (t.right != null
               && t.right.val == l.next.val) {
                tStk.push(t.right);
                lStk.push(l.next);
            }
        }
        return false;
    }
    
    public void search(TreeNode node) {
        if (node == null) {
            return;
        }
        map.putIfAbsent(node.val, new ArrayList());
        map.get(node.val).add(node);
        search(node.left);
        search(node.right);
    }
}