/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tortoise = head;
        if (tortoise.next == null) {
            return null;
        }
        ListNode hare = head;
        while (tortoise != null && hare != null) {
            tortoise = tortoise.next;
            if (hare.next == null
               || hare.next.next == null) {
                return null;
            }
            hare = hare.next.next;
            if (tortoise == hare) {
                break;
            }
        }
        ListNode intersection = tortoise;
        tortoise = head;
        // System.out.println(String.format("!t: %d, i: %d", tortoise.val, intersection.val));
        while (tortoise != intersection) {
            // System.out.println(String.format("t: %d, i: %d", tortoise.val, intersection.val));
            tortoise = tortoise.next;
            intersection = intersection.next;
        }
        return tortoise;
    }
}