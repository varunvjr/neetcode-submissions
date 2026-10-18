/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int findLen(ListNode n){
        int size = 0;
        while(n!=null){
            size++;
            n = n.next;
        }
        return size;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        len = findLen(head);
        int diff = len-n;
        if(diff==0)
            return head.next;
        ListNode prev = null;
        ListNode cur = head;
        for(int i=0;i<diff;i++){
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return head;
    }
}
