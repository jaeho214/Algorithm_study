package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_61_Rotate_List {
    public static void main(String[] args) {
        Leetcode_61_Rotate_List rotate_list = new Leetcode_61_Rotate_List();
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
        Queue<Integer> q = new LinkedList<>();

        if(head == null || head.next == null || k == 0)
            return head;

        int len = 0;
        while(head != null){
            len++;
            q.offer(head.val);
            head = head.next;
        }

        int cnt = len-(k%len);
        while(cnt > 0){
            q.add(q.poll());
            cnt--;
        }

        return new ListNode(q.poll(), getNext(q));
    }

    private ListNode getNext(Queue<Integer> q) {
        if (q.size() == 1)
            return new ListNode(q.poll());
        else
            return new ListNode(q.poll(), getNext(q));
    }
}
