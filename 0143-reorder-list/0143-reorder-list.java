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
    public void reorderList(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        
        Stack<ListNode> stk = new Stack();
        cur = head;
        for (int i=0; i<(n+1)/2; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            stk.push(cur);
            cur = cur.next;
        }
        
        cur = head;
        while (stk.size() > 0) {
            ListNode next = cur.next;
            cur.next = stk.pop();
            cur.next.next = next;
            cur = next;
        }
        cur.next = null;
        
        return;
    }
}