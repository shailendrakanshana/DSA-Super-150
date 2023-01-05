public class Remove_Cycle {
    public static ListNode MeetingPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return slow;
        }
        return null;
    }
    //Interative function
    public static void removeCycle(ListNode head){
        ListNode mpoint = MeetingPoint(head);
        if(mpoint==null) return;
        ListNode fast = head;
        int count  = 0;
        while(fast.next!=mpoint){
            fast = fast.next;
            count++;
        }
        for(int i = 0;i<=count;i++){
            fast = fast.next;
        }
        ListNode slow = head;
        while(slow.next!=fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
    //Function for print LL
    public static void print_LL(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next;
        removeCycle(head);
        print_LL(head);
    }
}
