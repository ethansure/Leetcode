# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        def mergeTwoLists(l1, l2):
            if l1 == None:
                return l2
            if l2 == None:
                return l1
            head = None
            if l1.val < l2.val:
                head = l1
                head.next = mergeTwoLists(l1.next, l2)
            else:
                head = l2
                head.next = mergeTwoLists(l1, l2.next)
            return head
        if len(lists) == 0:
            return None
        elif len(lists) == 1:
            return lists[0]
        elif len(lists) == 2:
            return mergeTwoLists(lists[0],lists[1])
        else:
            mid = int(len(lists)/2)
            return mergeTwoLists(self.mergeKLists(lists[0:mid]),self.mergeKLists(lists[mid:]))
            
    