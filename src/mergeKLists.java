import java.util.Collections;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int count = 0;
        LinkedList<Integer> resList = new LinkedList<Integer>();
        ListNode head = new ListNode(5);
        ListNode current = head;

        for (ListNode node : lists) {
            while (node != null) {
                resList.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(resList);
        for (int val : resList) {
            ListNode newNode = new ListNode(val);
            current.next = newNode;
            current = current.next;
        }


        return head.next;
    }
}
