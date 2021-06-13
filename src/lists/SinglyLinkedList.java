package lists;

public class SinglyLinkedList {
    ListNode head;

    public void insertAtTheBeginning(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtTheEnd(int data) {
        ListNode newNode = new ListNode(data);
        ListNode p = head;
        while(p.next != null) {
            p=p.next;
        }
        p.next = newNode;
    }

    public void displayList() {
        ListNode process = head;

        while(process != null) {
            System.out.print(process.data + " ");
            process = process.next;
        }
        System.out.println("");
    }

    public void displayListFromNode(ListNode node) {
        if(node == null)
            return;
        ListNode first = head;
        while(first != null && first != node) {
            first = first.next;
        }

        while(first != null) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.println("");
    }

    public void removeTheNodeWithValue(int x) {
//        1) check if the head is the key
//        2) delete the other node using two pointers
        ListNode first = head;
        ListNode prev = head;

        if(head == null) {
            return;
        }

        if(head.data == x) {
            head = first.next;
            return;
        }

        while(first != null) {
            if(first.data == x) {
                prev.next = first.next;
                return;
            }
            prev = first;
            first = first.next;
        }
    }


//    Delete a Linked List node at a given position
    public ListNode deleteNodeAtPosition(int x) {
        if(head == null) {
            return null;
        }

        ListNode first = head, prev = head;
        if(x == 1) {
            head = first.next;
            return head;
        }

        for(int i=0;i<x-1;i++) {
            prev = first;
            first = first.next;
        }

        if(first != null) {
            prev.next=first.next;
            return head;
        }
        return null;
    }
}
