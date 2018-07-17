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
    public ListNode detectCycle(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;
        boolean isCircled = false;
        while(oneStep != null && twoStep != null) {
            oneStep = oneStep.next;
            if (twoStep.next != null) {
                twoStep = twoStep.next.next;
                if (twoStep == oneStep) {
                    isCircled = true;
                    break;
                }
            } else {
                return null;
            }
        }
        if(!isCircled) return null;
        
        oneStep = head;
        while(oneStep != twoStep) {
            oneStep = oneStep.next;
            twoStep = twoStep.next;
        }
        return oneStep;
    }
}