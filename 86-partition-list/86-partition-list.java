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
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode smaller = new ListNode();
        ListNode bigger = new ListNode();
        ListNode scur = smaller;
        ListNode bcur = bigger;
        while (cur != null) {
            if (cur.val < x) {
                scur.next = new ListNode(cur.val);
                scur = scur.next;
            }
            else {
                bcur.next = new ListNode(cur.val);
                bcur = bcur.next;
            }
            cur = cur.next;
        }
        // printList(smaller);
        // printList(bigger);
        ListNode sentinel = new ListNode();
        sentinel.next = smaller.next;
        ListNode putCur = sentinel;
        while (putCur.next != null) {
            putCur = putCur.next;
        }
        putCur.next = bigger.next;
        return sentinel.next;
    }
    
    public void printList(ListNode a) {
        while (a != null) {
            System.out.print(a.val+" ");
            a = a.next;
        }
        System.out.println();
    }
}