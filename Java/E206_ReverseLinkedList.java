/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;
        while(head != null) {
            cur = head;
            head = cur.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}