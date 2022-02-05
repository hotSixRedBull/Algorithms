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
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (ListNode list : lists) {
            while (list != null) {
                pq.add(list.val);
                list = list.next;
            }
        }
        ListNode head = new ListNode();
        ListNode cur = head;
        while (pq.size() > 0) {
            cur.next = new ListNode(pq.poll());
            cur = cur.next;
        }
        return head.next;
    }
}