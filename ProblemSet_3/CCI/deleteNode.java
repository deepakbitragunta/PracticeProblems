public class deleteNode {
	public static void printList(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static void removeNode(Node n) {
		if(n == null) return ;
		System.out.println("Display");
		n.displayList();
		System.out.println("Display");
		if(n.next != null) {
			Node temp = n.next;
			n.data = temp.data;
			n.next = temp.next;
		}
		else{
			
		}
		
	}
	public static void main(String args[]) {
		
		Node head = new Node(12);
		head.appendValues(13);
		head.appendValues(12);
		head.appendValues(15);
		head.appendValues(16);
		head.appendValues(13);
		head.appendValues(13);
		Node temp = head; int count = 0;
		while(count < 4) {
			temp = temp.next;
			count++;
		}
		System.out.println("temp value:" + temp.data);
		removeNode(temp);
		printList(head);
	}
}