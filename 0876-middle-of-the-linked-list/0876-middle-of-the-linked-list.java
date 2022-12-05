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
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode tortoise = head;
        ListNode hare = head.next;
        // System.out.println(String.format("t: %d, h: %d", tortoise.val, hare.val));
        while (hare != null) {
            tortoise = tortoise.next;
            if (hare.next == null
               || hare.next.next == null) {
                break;
            }
            hare = hare.next.next;
            // System.out.println(String.format("t: %d, h: %d", tortoise.val, hare.val));
        }
        return tortoise;
    }
}