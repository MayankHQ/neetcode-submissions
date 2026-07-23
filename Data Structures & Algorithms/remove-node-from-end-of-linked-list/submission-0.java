/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        if(head == null) return head;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int remove = len-n+1;
        if(remove == 1){
            head = head.next;
            return head;
        }

        temp = head;
        ListNode prev = null;
        int cnt = 0;
        while(temp != null){
            cnt++;
            
            if(cnt == remove){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
