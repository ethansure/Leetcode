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
        ListNode twoStepNode = head;
        while(twoStepNode != null && twoStepNode.next != null && twoStepNode.next.next != null) {
            head = head.next;
            twoStepNode = twoStepNode.next.next;
            if (head == twoStepNode) {
                return true;
            }
        }
        return false;
    }
}