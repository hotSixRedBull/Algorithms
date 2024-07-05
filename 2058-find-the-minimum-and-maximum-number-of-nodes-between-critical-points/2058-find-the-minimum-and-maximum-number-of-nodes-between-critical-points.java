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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int pos=0;
        int minCriticalPos=-1;
        int lastCriticalPos=-1;
        ListNode cur = head;
        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE;
        while (cur != null
               && cur.next != null 
               && cur.next.next != null) {
            ListNode next = cur.next;
            ListNode nextNext = cur.next.next;
            if (cur.val < next.val
               && nextNext.val < next.val) {
                //localMaxima
                if (lastCriticalPos != -1) {
                    // System.out.println(String.format("pos+1: %d, lastCriticalPos: %d, pos+1-lastCriticalPos: %d, ans[0]: %d",pos+1, lastCriticalPos, pos+1-lastCriticalPos, ans[0]));
                    ans[0] = Math.min(ans[0], pos+1-lastCriticalPos);
                }
                else {
                    minCriticalPos = pos+1;
                }
                lastCriticalPos = pos+1;
            }
            else if (cur.val > next.val
               && nextNext.val > next.val) {
                //localMinima
                if (lastCriticalPos != -1) {
                    // System.out.println(String.format("pos+1: %d, lastCriticalPos: %d, pos+1-lastCriticalPos: %d, ans[0]: %d",pos+1, lastCriticalPos, pos+1-lastCriticalPos, ans[0]));
                    ans[0] = Math.min(ans[0], pos+1-lastCriticalPos);
                }
                else {
                    minCriticalPos = pos+1;
                }
                lastCriticalPos = pos+1;
            }
            cur = cur.next;
            pos++;
        }
        // System.out.println(String.format("lastCriticalPos: %d, minCriticalPos: %d",lastCriticalPos,minCriticalPos));
        if (lastCriticalPos != -1
           && minCriticalPos != -1
           && lastCriticalPos != minCriticalPos) {
            ans[1] = lastCriticalPos-minCriticalPos;
        }
        else {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }
}