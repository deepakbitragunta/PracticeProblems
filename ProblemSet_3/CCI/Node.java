public class Node {

	int data;
	Node next;
	
	public Node(int value) {
		this.data = value;
	}
	
	public void appendValues(int data) {
		Node newNode = new Node(data);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = newNode;
	}
	public void displayList() {
		Node temp = this;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
}