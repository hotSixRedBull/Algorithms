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
    public boolean isPalindrome(ListNode head) {
        List<Integer> li = new ArrayList();
        while (head != null) {
            li.add(head.val);
            head = head.next;
        }
        // System.out.println(li);
        int left = 0;
        int right = li.size()-1;
        while (left < right) {
            if (li.get(left) != li.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}