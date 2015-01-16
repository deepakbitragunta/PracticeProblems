public class StringReplace {
	static char vowels [] = {'a', 'e', 'i', 'o', 'u'};
	static char replacements [] = {'A', 'E', 'I', 'O', 'U'};
	
	public static void replaceChars(String input) {
		int i, j, third_vowel_pos = 0;
		int n = input.length();
		int count = 0;
		String output = "";
		boolean isVowel = false;
		
		for(i = 0; i < n; ++i) {
			isVowel  = false;
			for(j =0; j < vowels.length;++j) {
				if(input.charAt(i) == vowels[j]) {
					count++;
					isVowel = true;
					
					break;
				}
			}
					
			output += input.charAt(i);
			if(count == 3) {
				third_vowel_pos = i;
				break;
			}
		}
		count = 0;
		String temp = "";
		
		for(i = n - 1; i > third_vowel_pos; --i) {
			isVowel  = false;
			
			for(j =0; j < vowels.length && count < 4;++j) {
				if(input.charAt(i) == vowels[j]) {
					isVowel = true;
					count++;			
					break;
				}
			}
			if(isVowel) {
				temp += replacements[j];
			}
			else{		
				temp += input.charAt(i);
			}
		}
		for(i = temp.length() - 1; i >= 0; --i)
			output += temp.charAt(i);
		System.out.println(output);
	}
	
	public static void main(String args[]) {
		String input = "ac1;fheojkuvakioka";
		String input2 = "aei";
		String input3 = "aeiouia";
		
		replaceChars(input);
		replaceChars(input2);
		replaceChars(input3);
	}

}