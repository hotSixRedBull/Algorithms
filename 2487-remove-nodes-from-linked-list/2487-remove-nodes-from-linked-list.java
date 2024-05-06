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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stk = new Stack();
        ListNode cur = head;
        while (cur != null) {
            while (stk.size() > 0
                  && stk.peek() < cur.val) {
                stk.pop();
            }
            stk.push(cur.val);
            cur = cur.next;
        }
        Stack<Integer> reverse = new Stack();
        while (stk.size() > 0) {
            reverse.push(stk.pop());
        }
        ListNode ans = new ListNode(reverse.pop());
        cur = ans;
        while (reverse.size() > 0) {
            cur.next = new ListNode(reverse.pop());
            cur = cur.next;
        }
        return ans;
    }
}