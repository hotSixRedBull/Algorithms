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
    List<Integer> li;
    public TreeNode sortedListToBST(ListNode head) {
        li = new ArrayList();
        while (head != null) {
            li.add(head.val);
            head = head.next;
        }
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{0, li.size()-1});
        List<Integer> shuffled = new ArrayList();
        while (q.size() > 0) {
            int[] range = q.poll();
            if (range[0] < 0 || range[1] >= li.size() || range[0] > range[1]) {
                continue;
            }
            if (range[0] == range[1]) {
                shuffled.add(li.get(range[0]));
                continue;
            }
            int mid = range[0]-(range[0]-range[1])/2;
            shuffled.add(li.get(mid));
            q.add(new int[]{range[0], mid-1});
            q.add(new int[]{mid+1, range[1]});
        }
        TreeNode result = null;
        if (li.size() == 0) {
            return result;
        }
        result = new TreeNode(shuffled.get(0));
        for (int i=1; i<shuffled.size(); i++) {
            addNode(result, shuffled.get(i));    
        }
        return result;
    }
    
    public void addNode(TreeNode head, int val) {
        if (head.val > val) {
            if (head.left == null) {
                head.left = new TreeNode(val);
                return;
            }
            else {
                addNode(head.left, val);
            }
        }
        else {
            if (head.right == null) {
                head.right = new TreeNode(val);
                return;
            }
            else {
                addNode(head.right, val);
            }
        }
    }
}