public class LoopStart {
	
	public static Node findStartNode(Node head) {		
		Node slow = head;
		Node fast = head;
		
		while(slow != null) {
			if(slow == null || fast == null || fast.next == null)  return null;		
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) break;
		}
	
		slow = head;
		
		while(slow != fast ) {
			slow = slow.next;
			fast = fast.next;
		}
		// either of slow or fast
		return slow;
	}
	
	public static void main(String args[]) {
		
		Node head2 = new Node(5);
		head2.appendValues(7);
		head2.appendValues(8);
		head2.appendValues(9);
		head2.appendValues(9);
		head2.appendValues(2149);
		
		Node middle = head2;
		
		while(middle.next != null) {
			middle = middle.next;
		}
			
		head2.appendValues(18);
		head2.appendValues(19);
		head2.appendValues(29);
		head2.appendValues(39);
		
		Node last = head2;
		
		while(last.next != null) {
			last = last.next;
		}
		
		last.next = middle;
				
		
		Node start = findStartNode(head2);
		System.out.println(start.data);
		
	}
}