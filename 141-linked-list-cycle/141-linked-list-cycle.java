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
    Set<ListNode> set = new HashSet();
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (set.contains(head)) {
            return true;
        }
        set.add(head);
        return hasCycle(head.next);
    }
}