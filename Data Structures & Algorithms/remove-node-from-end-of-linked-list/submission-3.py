# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        arr = []
        curr = head
        while curr:
            arr.append(curr)
            curr = curr.next
        
        rem = len(arr) - n
        if rem == 0:
            return head.next
        
        arr[rem - 1].next = arr[rem].next
        return head