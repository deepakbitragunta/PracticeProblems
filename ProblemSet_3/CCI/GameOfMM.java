public class GameOfMM {
	
	public static class Result {
		int hits;
		int pseudo_hits;
	}
	// Assuming A to Z as the characters
	public static Result countHits(String guess, String solution) {
			int chars_present = 0;
			if(solution.length() != guess.length()) return null; // return 0 hits
			
			for(int i = 0; i < solution.length(); ++i) {
				chars_present |= (1 << (1 + solution.charAt(i) - 'A'));
			}
			Result r = new Result();
			
			for(int i = 0; i < guess.length(); ++i) {
				if(guess.charAt(i) == solution.charAt(i)) {
					r.hits++;
				} else if ( (chars_present & ( 1 << (1 + (guess.charAt(i) - 'A')))) >= 1 ) {
					r.pseudo_hits++;
				}
			}
			return r;
	}
	
	public static void main(String args[]) {
		String guess = "RGYB";
		String solution = "YGGB";
		
		Result s = countHits(guess, solution);
		System.out.println(s.hits + " " + s.pseudo_hits);
	}
}