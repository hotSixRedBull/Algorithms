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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aPointer = list1;
        for (int i=0; i<a-1; i++) {
            aPointer = aPointer.next;
        }
        ListNode bPointer = list1;
        for (int i=0; i<=b; i++) {
            bPointer = bPointer.next;
        }
        ListNode end = list2;
        while (end.next != null) {
            end = end.next;
        }
        aPointer.next = list2;
        end.next = bPointer;
        return list1;
    }
}