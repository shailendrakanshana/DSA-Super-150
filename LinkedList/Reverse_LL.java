public class Reverse_LL{
    //Recursive Approach
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        //Taking recursive instance

        ListNode newHead = reverse(head.next);

        //Reverseing
        head.next.next = head;
        head.next = null;

        return newHead;
    }
    //Interative Approach
    public static ListNode reverse_I(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
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
        head.next.next.next.next.next = new ListNode(6);
        print_LL(head);
        ListNode newHead = reverse(head);
        print_LL(newHead);
        ListNode newHead2 = reverse(newHead);
        print_LL(newHead2);
        
    }
}