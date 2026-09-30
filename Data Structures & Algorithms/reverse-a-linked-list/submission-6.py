class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        newHead = self.reverseList(head.next)
        agla = head.next
        head.next = None
        agla.next = head

        return newHead