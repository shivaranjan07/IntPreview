package lists.inplace_reversal;

public class ReverseSubList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    /**
     * Skip the first p-1 nodes, to reach the node at position p.
     * Remember the node at position p-1 to be used later to connect with the reversed sub-list.
     * Next, reverse the nodes from p to q using the same approach discussed in Reverse a LinkedList.
     * Connect the p-1 and q+1 nodes to the reversed sub-list.
     *
     * */
    private static ListNode reverse(ListNode head, int p, int q) {
        ListNode curr = head, prev = null;
        //skip p-1 nodes
        for(int i=0;curr!=null && i<p-1;i++) {
            prev = curr;
            curr = curr.next;
        }

        //remember the node at position p-1
        ListNode lastNodeOfFirstPart = prev;
        ListNode lastPartOfReversal = curr;
        ListNode next = null;

        for(int i=0;curr!=null&&i<=q-p;i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = prev;
        } else {
            head = prev;
        }

        lastPartOfReversal.next = curr;

        return head;
    }
}
