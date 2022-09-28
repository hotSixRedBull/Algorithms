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
        ListNode front = head;
        for (int i=0; i<n; i++) {
            front = front.next;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode cur = newHead;
        // System.out.println(front);
        while (front != null) {
            front = front.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return newHead.next;
    }
}