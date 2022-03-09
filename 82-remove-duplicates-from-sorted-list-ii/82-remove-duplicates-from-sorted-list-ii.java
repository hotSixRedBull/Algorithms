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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode cur = sentinel;
        
        while (cur != null) {
            if (cur.next == null
               || cur.next.next == null) {
                break;
            }
            ListNode next = cur.next;
            ListNode next2 = cur.next.next;
            while (next2 != null
                   && next.val == next2.val) {
                // System.out.println(String.format("next: %d, next2: %d", next.val, next2.val));
                while (next2 != null
                       && next.val == next2.val) {
                    next2 = next2.next;
                }
                next = next2;
                if (next2 == null) {
                    break;
                }
                next2 = next2.next;
                // System.out.println(String.format(">>next: %d, next2: %d", next.val, next2.val));
            }
            // System.out.println(String.format(">>cur: %d, next: %d", cur.val, next.val));
            cur.next = next;
            cur = cur.next;
        }
        
        return sentinel.next;
    }
}