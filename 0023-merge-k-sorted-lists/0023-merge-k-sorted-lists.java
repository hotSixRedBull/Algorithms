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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> {
            return a.val - b.val;
        });
        for (ListNode head : lists) {
            if (head == null) {
                continue;
            }
            pq.add(head);
        }
        
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while (pq.size() > 0) {
            ListNode top = pq.poll();
            cur.next = new ListNode(top.val);
            cur = cur.next;
            top = top.next;
            if (top == null) {
                continue;
            }
            pq.add(top);
        }
        return result.next;
    }
}