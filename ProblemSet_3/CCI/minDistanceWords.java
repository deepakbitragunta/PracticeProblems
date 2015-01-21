public class minDistanceWords {

	public static int calculateDist(String text[], String w1, String w2) {
		int min =  Integer.MAX_VALUE / 2;
		int min_pos1 = -min;
		int min_pos2 = -min;
		int min_dist = min;
		int dist;
		for(int i = 0; i < text.length; ++i) {
		
			if(text[i].equals(w1)) {
				min_pos1 = i;
				// if we have preferece for word order then comment the following 3 lines to get word1->word2 distance
				// otherwise, it is word1 ->word2 or word2 -> word1
				dist = min_pos1 - min_pos2;
				if( dist < min_dist) {
					min_dist = dist;
				}
			}	else if(text[i].equals(w2)) {
				min_pos2 = i;
				dist = min_pos2 - min_pos1;
				if( dist < min_dist) {
					min_dist = dist;
				}
			}
				
		}
		return min_dist;
	}
	public static int calculateDistOrdered(String text[], String w1, String w2) {
		int min = Integer.MAX_VALUE / 2;
		int min_pos1 = -min;
		int min_pos2 = -min;
		int min_dist = min;
		
		for(int i = 0; i < text.length; ++i) {
		
			if(text[i].equals(w1)) {
				min_pos1 = i;
				// if we have preferece for word order then comment the following 3 lines to get word1->word2 distance
				// otherwise, it is word1 ->word2 or word2 -> word1
			/*	int dist = min_pos1 - min_pos2;
				if( dist < mind_dist) {
					min_dist = dist;
				}
			*/
			}	else if(text[i].equals(w2)) {
				min_pos2 = i;
				int dist = min_pos2 - min_pos1;
				if( dist < min_dist) {
					min_dist = dist;
				}
			}
		
		}
		return min_dist;
	}
	
	public static void main(String args[]) {
		String text[] = {"adaa", "addd", "affg", "ddd", "haa", "fff", "hAa", "hhd", "ddd"};
		String word1 = "haa"; 
		String w2 = "ddd";
		System.out.println(calculateDist(text, word1, w2));
		System.out.println(calculateDistOrdered(text, word1, w2));
	}


}