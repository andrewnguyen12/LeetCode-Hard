import java.util.LinkedList;

public class reverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        LinkedList<Integer> resList = new LinkedList<Integer>();
        LinkedList<Integer> newList = new LinkedList<Integer>();
        ListNode head2 = new ListNode(0);
        ListNode prev = head2;

        //Store all nodes in a linkedlist
        while (head != null)
        {
            resList.add(head.val);
            head = head.next;
        }

        for (int i = 0 ; i < resList.size(); i += k)
        {
            //Before the final cycle, add the elements backward every k steps
            if (i <= (resList.size() - k))
            {
                for (int j = k-1; j >=0; j--)
                {
                    if ((i+j) < resList.size())
                    {
                        newList.add(resList.get(i+j));
                    }
                }
            }
            //In the final cycle, add the remaining elements forward
            else
            {
                for (int j = 0; j < k; j++)
                {
                    if ((i+j) < resList.size())
                    {
                        newList.add(resList.get(i+j));
                    }

                }
            }
        }

        //Store all elements in linkedlist as result ListNodes
        for (int x : newList)
        {
            ListNode newNode = new ListNode(x);
            prev.next = newNode;
            prev = prev.next;
        }

        return head2.next;

    }
}
