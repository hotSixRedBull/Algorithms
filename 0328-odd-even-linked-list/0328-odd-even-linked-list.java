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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode endStartNode = head;
        int len = 0;
        while (endStartNode.next != null) {
            endStartNode = endStartNode.next;
            len++;
        }
        
        ListNode cur = head;
        if (cur == endStartNode) {
            return cur;
        }
        
        ListNode endNode = endStartNode;
        while (len > 0) {
            endNode.next = new ListNode(cur.next.val);
            endNode = endNode.next;
            cur.next = cur.next.next;
            cur = cur.next;
            len -= 2;
            // cur = cur.next;
        }
        return head;
    }
}