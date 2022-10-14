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
    public ListNode deleteMiddle(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode hare = sentinel;
        ListNode tortoise = sentinel;
        
        while (hare.next != null
           && hare.next.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        tortoise.next = tortoise.next.next;
        return sentinel.next;
    }
}