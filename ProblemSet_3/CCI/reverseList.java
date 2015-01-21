public class reverseList {

	public static void reverseList(Node head) {
		Node prev = null;
		Node current = head;
		while(current != null) {
			Node temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		head = prev;
	}
	

}