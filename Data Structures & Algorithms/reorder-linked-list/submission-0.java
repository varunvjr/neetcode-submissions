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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sec = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode next = null;
        while(sec!=null){
            next = sec.next;
            sec.next = prev;
            prev = sec;
            sec = next;
        }
        sec = prev;
        ListNode first = head;
        while(sec!=null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = sec.next;
            first.next = sec;
            sec.next = tmp1;
            first = tmp1;
            sec = tmp2;
        }
        return;

    }
}
