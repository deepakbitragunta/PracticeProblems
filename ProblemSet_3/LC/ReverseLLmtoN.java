/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReverseLLmtoN {
    public ListNode reverseBetween(ListNode head, int m, int n) {
       
        if(m >= n || head == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        
        ListNode preNode = dummy;
        
        int i = 1;
        while(i < m) {
            if(preNode == null) return null;
            preNode = preNode.next;
            ++i;
        }
        
        ListNode start = preNode.next;
        ListNode cur = start.next;
        
        while(cur != null && i < n) {
            ListNode  next = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            start.next = next;
            cur = next;
            ++i;
        }
        
         return dummy.next;
    }
}