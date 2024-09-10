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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            cur.next = new ListNode(gcd(cur.val, next.val));
            cur = cur.next;
            cur.next = next;
            cur = cur.next;
            next = next.next;
        }
        return head;
    }
    public int gcd(int a, int b) {
        if (b > a) {
            return gcd(b,a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}