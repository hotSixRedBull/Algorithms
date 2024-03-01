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
    public String gameResult(ListNode head) {
        int odd = 0;
        int even = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (dummy != null && dummy.next != null) {
            int a = dummy.next.val;
            int b = dummy.next.next.val;
            if (a > b) {
                even++;
            }
            else {
                odd++;
            }
            dummy = dummy.next.next;
        }
        if (odd == even) {
            return "Tie";
        }
        else if (odd > even) {
            return "Odd";
        }
        else {
            return "Even";
        }
    }
}