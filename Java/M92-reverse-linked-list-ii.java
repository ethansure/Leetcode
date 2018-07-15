class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummyhead = new ListNode(0);
    dummyhead.next = head;
    ListNode sublisthead = new ListNode(0);
    ListNode sublisttail = new ListNode(0);
    int count = 1;
    ListNode pre_cur = dummyhead, cur = head;
    while(count <=n){
      ListNode temp = cur.next;
      if (count < m)
        pre_cur = cur;
      else if (count == m){
        sublisttail = cur;
        sublisthead.next = cur;
      }else if (count > m){
        cur.next = sublisthead.next;
        sublisthead.next = cur;
      }
      cur = temp;
      ++count;
    }
    pre_cur.next = sublisthead.next;
    sublisttail.next = cur;
    return dummyhead.next;
  }
}