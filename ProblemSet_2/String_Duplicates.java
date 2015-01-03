package programs;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class String_Duplicates {
	

	
/*
	public char[] sortCharacter(char[] input) {
		
	} 

	public void removeDuplicates_OrderLess(String input) {
		
	} */
	// Removes duplicates order is preserved O(n ^ 2) time, O(1) space
	public char[] removeDuplicates_Space(char input[]) {
			int i , j,  n = input.length;

			if (n <= 1) {
					return input;
			}
			for( i = 1; i < n; ++i) {
				for(j = i - 1; j >= 0; --j) {
					if(input[i] == input[j]) { input[i] = '\0'; break; } 
					
				}
			}
			return input;
	}

	// Removes duplicates order is preserved, uses bit array of size 256, O(n) time
	public HashMap<Character, Integer> removeDuplicates_Time(char input[]) {

		LinkedHashMap<Character, Integer> characters = new LinkedHashMap<Character, Integer>();

		int i = 0;
	
		for(i = 0; i < input.length; ++i) {
			
			if(characters.containsKey(input[i])) {
	//			characters.put(input[i], (Integer) characters.get(input[i]) + 1);
			}
			else {
				characters.put(input[i], 1);
			}
		}
	return characters;

	}
	public static void main (String args[]) {
		char input[] = {'a', 's', 'l', 'l', 'd', 'g', 'p', 'f', 'p'};
						
		String_Duplicates inputString = new String_Duplicates();
	
		//char unique_string[] = inputString.removeDuplicates_Space(input);
		
		
		HashMap<Character, Integer> unique_string2  = inputString.removeDuplicates_Time(input);

//		for(int i = 0; i < unique_string.length && unique_string[i] != '\0'; ++i) 
//				System.out.println(unique_string[i]);
//		
				System.out.println(unique_string2.keySet().toString());

			
	}


}
