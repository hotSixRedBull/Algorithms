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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode priorNode = head;
        for (int i=0; i<n; i++) {
            priorNode = priorNode.next;
        }
        ListNode sentinel = new ListNode(-1, head);
        ListNode cur = sentinel;
        while (priorNode != null) {
            cur = cur.next;
            priorNode = priorNode.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return sentinel.next;
    }
}