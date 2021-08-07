package lists.inplace_reversal;

public class ReverseEveryKElements {
    public static void main(String[] args) {
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next.next = new ListNode(7);
        head2.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverseKGroup(head2, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    public static ListNode reverse(ListNode head, int k) {
        if(head == null|| k<=0) {
            return head;
        }

        int count=0;
        ListNode curr=head;
        ListNode next = null, prev = null;

        while(count++ < k&&curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(next != null) {
            head.next = reverse(curr, k);
        }
        return prev;
    }

    public static ListNode reverse2(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;

        ListNode current = head, previous = null;
        while (current != null) {
            ListNode lastNodeOfPreviousPart = previous;
            // after reversing the LinkedList 'current' will become the last node of the sub-list
            ListNode lastNodeOfSubList = current;
            ListNode next = null; // will be used to temporarily store the next node
            // reverse 'k' nodes
            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // connect with the previous part
            if (lastNodeOfPreviousPart != null)
                lastNodeOfPreviousPart.next = previous; // 'previous' is now the first node of the sub-list
            else // this means we are changing the first node (head) of the LinkedList
                head = previous;

            // connect with the next part
            lastNodeOfSubList.next = current;

            // if (current == null) // break, if we've reached the end of the LinkedList
            //   break;
            // prepare for the next sub-list
            previous = lastNodeOfSubList;
        }

        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempNode = new ListNode(0);
        tempNode.next = head;
        ListNode tempHead = head;
        ListNode prev = tempNode;
        while(tempHead!=null){
            // Starting of each reversed list, it will become the last after reversing
            ListNode klast = tempHead;
            int num = k;
            // Jump k
            while(num>0 && tempHead!=null){
                tempHead = tempHead.next;
                num--;
            }
            // If cannot reverse
            if(num!=0) {
                prev.next = klast;
                break;
            }
            // start of each reversed group
            ListNode kstart = rev(klast,k);

            // Use previous's next to point to curr reversed
            prev.next = kstart;
            // Set prev to current rev end.
            prev = klast;

        }
        return tempNode.next;

    }

    // Standard reverse code
    public static ListNode rev(ListNode head, int k){
        ListNode prev = null;
        while(head!=null && k>0){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            k--;
        }
        return prev;
    }

}
