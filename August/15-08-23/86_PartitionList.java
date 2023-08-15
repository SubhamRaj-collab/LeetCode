public class 86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        
        //I understood the question when I read one of the comments from discussion

        ListNode dummy = new ListNode(-101);
        ListNode t = dummy;

        ListNode temp = head;

        while(temp != null)
        {
            if(temp.val < x)
            {
                t.next = new ListNode(temp.val);
                t = t.next;
            }

            temp = temp.next;
            
        }

        temp = head;

        while(temp != null)
        {
            if(temp.val >= x)
            {
                t.next = new ListNode(temp.val);
                t = t.next;
            }

            temp = temp.next;
            
        }

        return dummy.next;

    }
}
