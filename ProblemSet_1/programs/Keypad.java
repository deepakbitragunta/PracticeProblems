public class Keypad {
	public static void allowed(int[] a){
		int[][] keypad = {{1,2,3},
						  {4,5,6},
						  {7,8,9}};
		int[] code = {1,4,7,8};
		boolean mistake = false;
		for(int i=0; i<a.length; i++){
			if(a[i] == code[i]){
				continue;
			}
			else if(a[i] != code[i]){
				mistake = false;
				
				for(int j=0; j< 3; j++ ){
					for(int k=0; k< 3; k++){
						if(code[i] == keypad[j][k]){
							boolean problem = true;;
							if(j-1>=0 && keypad[j-1][k] == a[i]){
								problem = false;
							}
							if(j+1<=2 && keypad[j+1][k] == a[i]){
								problem = false;
							}
							if(k-1>=0 && keypad[j][k-1] == a[i]){
								problem = false;
							}
							if(k+1<=2 && keypad[j][k+1] == a[i]){
								problem = false;
							}
							if(problem == true){
								System.out.println("Not Allowed!");
								return;
							}
							else {
								mistake = true;	
								break;
							}
						}
					}
					if(mistake) {
						break;
					}
					
				}
				
			}
		}
		System.out.println("Allowed!");
	}
	public static boolean checkPassword(String actual, String expected) {
		
		int m = actual.length(), n = expected.length();
		int i = 0, j = 0;
		//if(m > n) { System.out.println("Invalid input");}
		char fault = '\0';
		
		for(; i < m && j < n; ++j) {
			if(actual.charAt(i) != expected.charAt(j)) {
				if(fault == '\0') 
					fault = expected.charAt(j);
				else {
					if(expected.charAt(j) != fault) return false;
				}
				--i;
			}
			else{
				if(fault != '\0' && actual.charAt(i) == fault) return false;
			}
			++i;
		}
		
		while(j < n && expected.charAt(j) == fault) j++;
		
		return(i == m  && j == n) ? true : false;	
	
	}
	
	public static void main(String args[]) {
		String actual = "12746";
		String expected = "12646";
		int ar[] = {2,5,7,8};
		System.out.println(checkPassword(actual, expected));
	//	allowed(ar);
	}

}