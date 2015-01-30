import java.util.ArrayList;
import java.util.Collections;

class htwt implements Comparable{
	int height;
	int weight;
	
	public htwt(int h, int w) {
		height = h;
		weight = w;
	}
	
	public boolean isBefore(htwt next) {
		return (this.height < next.height && this.weight < next.weight);
	
	}

	public int compareTo(Object arg0) {
		
		if(this.height ==  ((htwt)arg0).height) {
			if(this.weight == ((htwt)arg0).weight) {
				return 0;
			}
			else if(this.weight < ((htwt)arg0).weight) {
				return -1;
			}
			else 
				return 1;
		}
		else if(this.height < ((htwt)arg0).height) {
			return -1;
		}
		else 
			return 1;
	}

	/*@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}*/

	
}

public class HeightWeightOrder {
	
	ArrayList<htwt> items;
	ArrayList<htwt> lastSeq;
	ArrayList<htwt> maxSeq;
	
	public void HeightWeightOrder() {
		items = new ArrayList<htwt>();
		lastSeq = new ArrayList<htwt>();
		maxSeq = new ArrayList<htwt>();
		
	}
	public ArrayList<htwt> compareSequences(ArrayList<htwt> seq1, ArrayList<htwt> seq2) {
		if(seq1 == null) return seq2;
		else if (seq2 == null) return seq1;
		return seq1.size() < seq2.size() ? seq2 : seq1;
	}
	
	
	public int fillNextSeq(int start,  ArrayList<htwt> nextSeq){
		int firstUnfit = start;
		
		if(start < items.size()) {
			System.out.println("test");
			for(int i = start; i < items.size(); ++i) {
				htwt item = items.get(i);
				if(i == start || items.get(i - 1).isBefore(item)) {
					nextSeq.add(item);
				}
				else {
					firstUnfit = i;
					break;
				}
			}
		}
		return firstUnfit;	
	}
	
	public ArrayList<htwt> findMaxSequence() {
	
		Collections.sort(items);
		int current = 0;
		
		while(current < items.size()) {
			ArrayList<htwt> nextSeq = new ArrayList<htwt>();
			int next = fillNextSeq(current, nextSeq);
			maxSeq = compareSequences(maxSeq, nextSeq);
			if(next == current) break;
			else current = next;
		}
		return maxSeq;
	}
	public static void main(String args[]) {
		HeightWeightOrder hwo = new HeightWeightOrder();
		hwo.items = new ArrayList<htwt>();
		hwo.items.add(new htwt(58, 69));
		hwo.items.add(new htwt(51, 62));
		hwo.items.add(new htwt(50, 61));
		hwo.items.add(new htwt(57, 64));
		hwo.items.add(new htwt(54, 65));
		hwo.items.add(new htwt(59, 69));
		hwo.items.add(new htwt(51, 62));
		hwo.items.add(new htwt(53, 61));
		hwo.items.add(new htwt(52, 60));
		hwo.items.add(new htwt(51, 59));
		ArrayList<htwt> maxSeq = hwo.findMaxSequence();
		for(int i = 0; i < hwo.maxSeq.size(); ++i) {
			System.out.println("(" + maxSeq.get(i).height + ", " + maxSeq.get(i).weight + ")");
		}
	}
}