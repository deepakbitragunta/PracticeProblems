import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class wordTransform {

	public static Set<String> getEditedWords(String w) {
			Set<String> s = new TreeSet<String>();
			
			for(int i = 0; i < w.length(); ++i) {
				char chars[] = w.toCharArray();
				
				for(char j = 'a'; j < 'z'; ++j) {
					if(w.charAt(i) != j) {
						chars[i] = j;
						s.add(new String(chars));
					}			
				}			
			}
		return s;
	
	}
	public static LinkedList<String> transform(Set<String> dict, String start, String stop) {
	
		start = start.toUpperCase();
		stop = stop.toUpperCase();
		Set<String> visited = new HashSet<String>();
		Queue<String> actionQueue = new LinkedList<String>();
		Map<String,String> backtrack = new TreeMap<String, String>();
		
		actionQueue.add(start);
		visited.add(start);
		
		while(!actionQueue.isEmpty()){
			String w = actionQueue.poll();
			
			for(String s : getEditedWords(w)){ 
				// reached the destination word
				if(s.equals(stop)) { 
					LinkedList<String> list = new LinkedList<String>();
					list.add(s);
					while(w != null) {
						list.add(0, w);
						w = backtrack.get(w);
					}
					return list;	
				}
				else if(dict.contains(s)) {
					if(!visited.contains(s)) {
						actionQueue.add(s);
						visited.add(s);
						backtrack.put(s, w);
						
					}
				}
			}			
		}
		return null;		
	}
	
	 public static int ladderLength(String start, String end, Set<String> dict) {
        
        int count = 0;
        start = start.toLowerCase();
        
        String t = start;
        for(String s : getEditedWords(t)) {
            if(s.equals(end)) {
                count++;
                return count;
            } else if(dict.contains(s)) {
                count++;
                t = s;
            } 
        }
         return count;
    }

	public static void main(String args[]) {
		
		Set<String> d = new TreeSet<String>();
		d.add("hOT"); 
		d.add("DOG"); // d.add("ADI"); d.add("IDI"); d.add("ICI");
	//	LinkedList<String> l = transform(d, "Add", "IPI");
		System.out.println(ladderLength("HOT", "DOG", d));
	}

}