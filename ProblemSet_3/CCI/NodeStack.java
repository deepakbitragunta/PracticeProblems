public class NodeStack {
	
	Node top;
	public  void push(int item) {
			Node temp = new Node(item)
			temp.next = top;
			top = temp;
	}

	public int pop() {
		if(top != null) {
			int k = top.data;
			top = top.next;
			return k;
		}
		return null;
	}

}