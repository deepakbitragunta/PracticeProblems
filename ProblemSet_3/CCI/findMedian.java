import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class maxheapComparator implements Comparator {
	

	@Override
	public int compare(Object arg0, Object arg1) {
		return ((Integer) arg1 - (Integer) arg0);
	}

}

public class findMedian {

	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new maxheapComparator());
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	
	Comparator<Integer> maxHeapcomp, minHeapComp;
	public  static void addNewNumber(int num) {
	
		if(maxHeap.size() == minHeap.size()) {
			if(minHeap.peek() != null && num > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(num);
			} else {
				maxHeap.offer(num);
			}
		} else {
				if(num < maxHeap.peek()) {
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(num);
					} else {
					minHeap.offer(num);
					}
				}
	}
	
	public static int getMedian() {
		if(maxHeap.isEmpty()) return minHeap.peek(); 
		else if(minHeap.isEmpty()) return maxHeap.peek();
		if(maxHeap.size() == minHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2;
		}	else if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else 
			return minHeap.peek();
	}
	
	public static void main(String args[]) {
	
		int a[] = {3, 1, 5, 2, 5, 8};
		
		for(int i = 0; i < a.length; ++i) 
				addNewNumber(a[i]);
		System.out.println(getMedian());
	}

}