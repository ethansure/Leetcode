/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        convertToStack(l1,s1);
        convertToStack(l2,s2);
        return addStack(null, s1, s2, 0);
    }
    private void convertToStack(ListNode node, Stack<Integer> s) {
        if (node == null) {
            return;
        } else {
            s.push(node.val);
            convertToStack(node.next,s);
        }
    }
    private ListNode addStack(ListNode node, Stack<Integer> s1, Stack<Integer> s2, int a) {
        int val = 0, n1 = 0, n2 = 0;
        if (s1.size() == 0 && s2.size() == 0 && a == 0) {
            return node;
        }
        if (s1.size() > 0) {
            n1 = s1.pop();
        }
        if (s2.size() > 0) {
            n2 = s2.pop();
        }
        val  = (n1 + n2 + a) % 10;
        a = (n1 + n2 + a) / 10;
        ListNode nn = new ListNode(val);
        nn.next = node;
        return addStack(nn,s1, s2, a);
    }
}