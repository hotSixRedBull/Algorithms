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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode cur = sentinel;
        while (cur != null) {
            if (cur.next == null) {
                break;
            }
            ListNode next = cur.next;
            while (next != null 
                   && set.contains(next.val)) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return sentinel.next;
    }
}