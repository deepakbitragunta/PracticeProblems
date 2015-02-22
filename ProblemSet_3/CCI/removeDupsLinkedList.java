import java.util.Hashtable;

public class removeDupsLinkedList {
	public static void printList(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	// Using hash table as additional storage O(n) space and time
	public static void removeDupsSpace(Node head) {
		Node n = head;
		Node previous = null;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		if(n == null) return;
		
		while(n != null) {
			if(table.containsKey(n.data)) {
					previous.next = n.next;
			}
			else{
					table.put(n.data, true);
					previous = n;
			}
			n = n.next;
		}
	
		printList(head);
	}
	
	// Using two pointers O(n ^ 2) time O(1) space
	public static void removeDups(Node head) {
			if(head == null || head.next == null) return;
		Node previous = head;
		Node current = head.next;
		Node runner = head;
		
		while(current != null) {			
					runner = head;
					while(runner != current) {
						if(runner.data == current.data) {
							 Node next = current.next;
							 previous.next = next;
							 current  = next;	
							 break;
						}
						runner = runner.next;
					}
					if(current == runner) {
						previous = current;
						current = current.next;
					}
			}
		printList(head);
	}
	public static void main(String args[]) {
		Node head = new Node(12);
		head.appendValues(13);
		head.appendValues(12);
		head.appendValues(15);
		head.appendValues(16);
		head.appendValues(13);
		head.appendValues(13);
		removeDups(head);
	//	removeDupsSpace(head);
	}
}

