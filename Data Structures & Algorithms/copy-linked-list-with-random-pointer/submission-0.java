/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        insertCopy(head);
        assignRandomPointer(head);
        return deepCopy(head);
    }
    public void insertCopy(Node head){
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;

            temp = temp.next.next;
        }
    }
    public void assignRandomPointer(Node head){
        Node temp = head;
        while(temp != null){
            Node newNode = temp.next;
            if(temp.random != null){
                newNode.random = temp.random.next;
            }
            else{
                newNode.random = null;
            }
            temp = temp.next.next;
        }
    }
    public Node deepCopy(Node head){
        Node temp = head;
        Node dummy = new Node(-1);
        Node curr = dummy;
        while(temp != null){
            curr.next = temp.next;
            curr = curr.next;

            temp.next = curr.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
