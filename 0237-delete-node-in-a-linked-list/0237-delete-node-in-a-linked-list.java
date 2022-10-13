/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        while (node != null) {
            int tmp = node.val;
            node.val = node.next.val;
            node.next.val = tmp;
            if (node.next.next == null) {
                node.next = null;
                break;
            }
            // System.out.println(node.val);
            node = node.next;
        }
        // System.out.println("end");
    }
}