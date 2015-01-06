import java.util.Stack;

	
	

public class Tower {
	int index;
	Stack<Integer> disks;
	
	public Tower(int index) {
		disks = new Stack<Integer>();
		this.index = index;
	}
	public void add(int d) {
		if(!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("d = " + d + " peek: " + disks.peek());
			System.out.println("Error placing the disk");
		}
		else{
			disks.push(d);
		}
	}
	public int getIndex() {
		return index;
	}
	
	public static void moveTopTo(Tower s, Tower t) {
		int top = s.disks.pop();
		System.out.println(top);
		t.add(top);
		System.out.println("Moving disk " + top + " from " + s.getIndex() + " to " + t.getIndex());
	}
	
	public static void print(Tower t) {
		System.out.println("Contents of tower");		
		for(int i = t.disks.size() - 1; i >= 0; --i) {
			System.out.println("  " + t.disks.get(i));
		}	
	}
	
	public static void moveDisks(int n, Tower source, Tower destination, Tower buffer) {
		if(n >  0) {
			moveDisks(n - 1, source, buffer, destination);
			moveTopTo(source, destination);
			moveDisks(n - 1, buffer, destination, source);
		}
	}
	public static void main(String args[]) {
		int i, n = 5;
		
		Tower[] tows = new Tower[n];
		for(i = 0; i < 3; ++i) {
			tows[i] = new Tower(i);
		}
		for(i = n - 1; i >= 0;  --i) {
			tows[0].add(i);
		}
		moveDisks(n, tows[0], tows[2], tows[1]);
		print(tows[2]);
	}
	
}