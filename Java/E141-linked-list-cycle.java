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
    public boolean hasCycle(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;
        while(oneStep != null && twoStep != null) {
            oneStep = oneStep.next;
            if (twoStep.next != null) {
                twoStep = twoStep.next.next;
                if (twoStep == oneStep) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}