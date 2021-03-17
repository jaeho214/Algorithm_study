package leetCode;

public class Leetcode_19_Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        Leetcode_19_Remove_Nth_Node_From_End_of_List remove_nth_node_from_end_of_list = new Leetcode_19_Remove_Nth_Node_From_End_of_List();
        ListNode listNode = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(remove_nth_node_from_end_of_list.removeNthFromEnd(listNode, 2));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null && n == 1)
            return null;

        ListNode front = head;
        ListNode back = head;
        int cnt = 0;

        while(cnt != n){
            if(back == null)
                return null;
            back = back.next;
            cnt++;
        }

        if(back == null)
            return head.next;

        while(back.next != null) {
            back = back.next;
            front = front.next;
        }

        front.next = front.next != null ? front.next.next : null;
        return head;

    }
}
