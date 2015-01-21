import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class topKWords {

	public static HashMap<String, Integer> createKWordsMap(String words[]) {
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		
		for(int i = 0; i < words.length; ++i) {
			if(wordMap.containsKey(words[i]))
				wordMap.put(words[i], wordMap.get(words[i]) + 1);
			else 
				wordMap.put(words[i], 1);
		}
		
		return wordMap;
	}
	static class maxHeapComparator implements Comparator<Map.Entry<String, Integer>> {
		public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
    int freq = e2.getValue().compareTo(e1.getValue()); //compares integer frequencies
    if (freq == 0) // two words occur equally frequently
      return e1.getKey().compareTo(e2.getKey());
    return freq;
		}

	}
	public static PriorityQueue<Map.Entry<String, Integer>> findKWords(HashMap<String, Integer> wordMap, int k) {
		Comparator<Map.Entry<String, Integer>> c =  (Comparator<Entry<String, Integer>>) new maxHeapComparator();
		PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<Map.Entry<String, Integer>>(k, c);
		
		for(Map.Entry<String, Integer> e : wordMap.entrySet()) {
			maxHeap.add(e);	
		}
		return maxHeap;
	}

	public static void main(String args[]) {
		String [] s = {"aaa", "aff", "abb", "acc", "aaa", "aff", "acc", "aff", "aaa", "aaa"};
		HashMap h = createKWordsMap(s);
		
		PriorityQueue<Map.Entry<String, Integer>> p = findKWords(h, 2);
		//Object [] items =  p.toArray();
		
		for(int i = 0; i < p.size(); ++i) {
			Map.Entry<String, Integer> e = p.poll();
			System.out.println( e.getKey() + " - " + e.getValue());
		}		
	}
}