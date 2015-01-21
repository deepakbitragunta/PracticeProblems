public class nthFromLast {
	
	public static int findNth(Node head, int n) {
		if(head == null) return -1;
		
		Node front = head, back = head;
		int count = 0;
		
		while(back != null && count < n ) {
			back = back.next;
			count++;
		}
		while(back != null) {
			front = front.next;
			back = back.next;
		}
		return front.data;
	}
	
	public static void main(String args[]){
		Node head = new Node(12);
		head.appendValues(13);
		head.appendValues(12);
		head.appendValues(15);
		head.appendValues(16);
		head.appendValues(13);
		head.appendValues(13);
		System.out.println(findNth(head, 3));
	}
}