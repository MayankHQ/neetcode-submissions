# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        minheap = []
        for i, node in enumerate(lists):
            if node:    
                heapq.heappush(minheap, (node.val, i, node))
        
        dummy = ListNode(-1)
        temp = dummy

        while minheap:
            val, i, node = heapq.heappop(minheap)
            temp.next = node
            temp = temp.next
            if node.next:
                heapq.heappush(minheap, (node.next.val, i, node.next))
        
        return dummy.next