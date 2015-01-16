public class NodeQueue {
	Node front, back;
	
	public void enqueue(int item) {
		if(!front) {
			back = new Node(item);
			front = back;
		}
		else {
			back.next = new Node(item);
			back = back.next;
		}
	}
	
	public int dequeue() {
		if(front) {
			int item = front.data;
			front = front.next;
		}
		return null;
	}



}