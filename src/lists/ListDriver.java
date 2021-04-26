package lists;

public class ListDriver {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtTheBeginning(9);
        sll.insertAtTheBeginning(7);
        sll.insertAtTheBeginning(5);
        sll.insertAtTheBeginning(2);
        sll.insertAtTheEnd(11);
        sll.displayList();
        sll.removeTheNodeWithValue(11);
        sll.displayList();
    }
}
