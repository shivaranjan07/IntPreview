package lists;

public class DoublyLinkedList {
    DLLNode head;
    
    public DLLNode insertAtBeginning(int data) {
        DLLNode node = new DLLNode(data);
        if(head == null) {
            head = node;
            return head;
        }
        
        node.next = head;
        head.prev = node;
        head = node;

        return head;
    }

    public DLLNode insertAtTheEnd(int data) {
        DLLNode newNode = new DLLNode(data);
        if(head == null) {
            head = newNode;
            return head;
        }

        DLLNode first = head;
        while(first.next != null) {
            first = first.next;
        }

        first.next = newNode;
        newNode.prev = first;
        return head;
    }

    public void insertAfterTheNode(DLLNode prev, int data) {
        DLLNode newNode = new DLLNode(data);

        if(prev == null) {
            System.out.println("prev should not be null");
            return;
        }

        newNode.next = prev.next;
        prev.next = newNode;
        newNode.prev = prev;

        //handling with newNode
        if(newNode.next != null)
            newNode.next.prev = newNode;
    }

    public DLLNode insertBeforeTheNode(DLLNode nextNode, int data) {
        DLLNode newNode = new DLLNode(data);

        newNode.next = nextNode;
        newNode.prev = nextNode.prev;
        nextNode.prev = newNode;

        //handling with newNode
        if(newNode.prev != null) {
            newNode.prev.next = newNode;
        } else {
            head = newNode;
        }

        return head;
    }

    public void displayList() {
        DLLNode process = head;

        while(process != null) {
            System.out.print(process.data + " ");
            process = process.next;
        }
        System.out.println("");
    }

    public void displayListFromNode(DLLNode node) {
        if(node == null)
            return;
        DLLNode first = head;
        while(first != null && first != node) {
            first = first.next;
        }

        while(first != null) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.println("");
    }

    public DLLNode deleteANode(int data) {
        if(head.data == data) {
            head = head.next;
            return head;
        }

        DLLNode first = head;

        while (first.data != data) {
            first = first.next;
        }

        if(first.prev != null)
            first.prev.next = first.next;
        if(first.next != null)
            first.next.prev = first.prev;

        return head;
    }

    public DLLNode deleteAtTheBegining() {
        if(head == null || head.next == null) {
            return null;
        }

        head = head.next;
        head.prev = null;

        return head;
    }

    public DLLNode deleteTheEnd() {
        if(head == null) {
            return null;
        }

        DLLNode first = head;

        while(first.next != null) {
            first=first.next;
        }

        first.prev.next = null;

        return head;
    }
    
}
