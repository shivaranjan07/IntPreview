package lists.inplace_reversal;

class RotateList {

    public static ListNode rotate(ListNode head, int rotations) {
        if(head == null || head.next == null || rotations <=0)
            return head;

        int listSize = 1;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            listSize++;
        }

        tail.next = head;

        rotations = rotations%listSize;
        int skipLen = listSize - rotations;

        // find the last node of rotated sub list 0 to skipLen-1;
        ListNode lastNodeSubList = head;
        for(int i=0;i<skipLen-1;i++) {
            lastNodeSubList = lastNodeSubList.next;
        }

        head = lastNodeSubList.next;
        lastNodeSubList.next = null;

        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(11);
        head.next = new ListNode(23);
        head.next.next = new ListNode(17);
        head.next.next.next = new ListNode(21);
        head.next.next.next.next = new ListNode(17);
        // head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
