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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = null;
        ListNode sec = null;
        int carry = 0;
        while(l1!=null||l2!=null){
            int n1 = l1!=null?l1.val:0;
            int n2 = l2!=null?l2.val:0;
            int sum = n1+n2+carry;
            carry = sum/10;
            sum = sum%10;
            if(first==null){
                first = new ListNode(sum);
                sec = first;
            }else{
                while(sec.next!=null)
                    sec = sec.next;
                sec.next = new ListNode(sum);
                sec = sec.next;
            }
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }
        if(carry!=0)
            sec.next = new ListNode(carry);

        return first;
    }
}
