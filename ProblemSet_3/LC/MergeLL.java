class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
  }
 
public class MergeLL {
    
    public static ListNode advanceNode(ListNode h, int k) {
        while(k > 0 && h != null) {
            h = h.next;
            k--;
        }
        return h;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) return null;
        
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        int size1 = 0;
        int size2 = 0;
        
        while(temp1.next != null) {
            size1++;
            temp1 = temp1.next;
           
        }
        
        while(temp2.next != null) {
            size2++;
            temp2 = temp2.next;
        }
        
        if(size1 > size2) {
            headA = advanceNode(headA, size1 - size2);
        } else {
            headB = advanceNode(headB, size2 - size1);
        }
        if(headA == null || headB == null) return null;
        
        while(headA.val != headB.val) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
		public static void main(String args[]) {
			ListNode ha = new ListNode(1);
			ListNode t = ha;
			for(int i = 3; i < 22; i = i + 2) {
			ListNode temp = new ListNode(i);
				t.next = temp;
				t = t.next;
			}
			
			ListNode hb = new ListNode(2);
			
			ListNode r = getIntersectionNode(ha, hb);
			System.out.println(r.val);
		}
}