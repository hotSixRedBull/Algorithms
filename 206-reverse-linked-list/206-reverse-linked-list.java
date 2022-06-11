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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            ListNode nextNext = next.next;
            next.next = cur;
            cur.next = prev;
            prev = cur;
            cur = next;
            next = nextNext;
        }
        return cur;
    }
}