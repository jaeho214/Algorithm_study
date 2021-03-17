package leetCode;

public class Leetcode_61_Rotate_List_FASTER {
    public static void main(String[] args) {
        Leetcode_61_Rotate_List_FASTER rotate_list = new Leetcode_61_Rotate_List_FASTER();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(rotate_list.rotateRight(listNode, 2));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() { }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0)
            return head;

        ListNode fast, slow;
        int size = 0;
        ListNode dummy = head;

        while(dummy != null){
            size ++;
            dummy = dummy.next;
        }

        k = k>=size ? k%size: k;

        if(k==0) return head;

        int idx = k;
        fast = head;
        slow = head;

        while(idx > 0){
            fast = fast.next;
            idx--;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode current = slow.next;
        //slow와 head가 주소가 같어서 null로 바꿀때 head도 함께 잘림
        slow.next = null;
        fast.next = head;

        return current;
    }
}
