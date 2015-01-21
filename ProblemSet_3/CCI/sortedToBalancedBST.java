public class sortedToBalancedBST {
	
	public static Node createTree(int a[]) {
		if(a == null) return null;
		
		createTree(int a[], 0, a.length - 1);
	}
	public static Node createTree(int a[], int l, int r) {
		if(l > r) {
			return null;
		}
		
		int mid = l + (r - l) / 2;
		Node r = new Node(a[mid]);
		r.left = createTree(a, left, mid - 1);
		r.right = createTree(a, mid + 1, right);
	
		return r;
	}
	LinkedList<Integer> h; // head
		public static Node createTree(int a[], int l, int r) {
		if(l > r) {
			return null;
		}
		
		int mid = l + (r - l) / 2;
		
		Node left = createTree(a, left, mid - 1);
		Node root = new Node(h.val);
		h = h.next;
		Node right = createTree(a, mid + 1, right);
		r.left = left;
		r.right = right;
		
		return r;
	}
	public static void main(String args[]) {
		int a[] = {2, 3, 8, 9, 10, 11, 12, 15, 16, 17, 21};
		
		Node root = createTree(a);
	
	}


}