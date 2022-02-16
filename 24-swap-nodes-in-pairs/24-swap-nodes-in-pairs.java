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
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode cur = sentinel;
        while (cur != null) {
            if (cur.next == null || cur.next.next == null) {
                break;
            }
            ListNode first = cur.next;
            ListNode second = first.next;
            ListNode third = second.next;
            cur.next = second;
            second.next = first;
            first.next = third;
            cur = cur.next.next;
        }
        
        return sentinel.next;
    }
}