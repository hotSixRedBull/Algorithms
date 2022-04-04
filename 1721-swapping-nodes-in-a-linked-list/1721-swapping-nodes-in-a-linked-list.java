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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode a = null;
        ListNode b = null;
        ListNode cur = sentinel;
        for (int i=0; i<k; i++) {
            cur = cur.next;
        }
        a = cur;
        // System.out.println(String.format("a: %d", a.val));
        
        int len = k;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        
        cur = sentinel;
        for (int i=0; i<len-k; i++) {
            cur = cur.next;
        }
        b = cur;
        // System.out.println(String.format("b: %d", b.val));
        
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
        
        return sentinel.next;
    }
}