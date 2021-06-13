package lists;

public class ListDriver {
    public static void main(String[] args) {
//        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.insertAtTheBeginning(9);
//        sll.insertAtTheBeginning(7);
//        sll.insertAtTheBeginning(5);
//        sll.insertAtTheBeginning(2);
//        sll.insertAtTheEnd(11);
//        sll.displayList();
//        sll.removeTheNodeWithValue(11);
//        sll.displayList();
//        ListNode listNode = sll.deleteNodeAtPosition(2);
//        sll.displayListFromNode(listNode);

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(2);
        DLLNode temp = dll.insertAtTheEnd(4);
        dll.insertAfterTheNode(temp, 5); // 2 5 4
        dll.displayListFromNode(temp);
        DLLNode temp2 = dll.insertBeforeTheNode(temp, 1); // 1 2 5 4
        dll.displayListFromNode(temp2);
        dll.insertAtTheEnd(6);
        DLLNode start = dll.insertAtBeginning(0);
        dll.displayList();
        DLLNode temp3 = dll.deleteANode(6);
        dll.displayListFromNode(temp3);

    }
}
