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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode leftNode = sentinel;
        for (int i=0; i<left-1; i++) {
            leftNode = leftNode.next;
        }
        // System.out.println(leftNode.val);
        
        Stack<ListNode> stk = new Stack();
        
        ListNode rightNode = leftNode.next;
        for (int i=left; i<=right; i++) {
            // System.out.println(String.format("push %d", rightNode.val));
            stk.push(rightNode);
            rightNode = rightNode.next;
        }
        while (stk.size() > 0) {
            ListNode top = stk.pop();
            leftNode.next = top;
            leftNode = leftNode.next;
        }
        leftNode.next = rightNode;
        
        return sentinel.next;
    }
}