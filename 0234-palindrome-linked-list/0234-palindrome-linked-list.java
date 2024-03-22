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
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int half = n % 2 == 1 ? (n+1)/2 : n/2;
        ListNode later = head;
        Stack<Integer> stk = new Stack();
        for (int i=0; i<half; i++) {
            stk.push(later.val);
            later = later.next;
        }
        if (n % 2 == 1) {
            stk.pop();
        }
        while (later != null) {
            if (later.val == stk.peek()) {
                stk.pop();
            }
            else {
                return false;
            }
            later = later.next;
        }
        return true;
    }
}