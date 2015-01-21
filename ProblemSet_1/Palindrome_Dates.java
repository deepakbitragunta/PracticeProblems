public class Palindrome_Dates {
	
	static int days[] = {0, 31,28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
	public static boolean isLeapYear(int year) {
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			return true;
		}
		return false;	
	}
	
	public static int numberOfDaysinMonth(int month, int year) {
		if(isLeapYear(year) && month == 2) {
			return 29;
		}
		return days[month];
	}
	
	public static String reverseYear(String year) {
		String reverse = "";
		
		for(int i = year.length() - 1; i >= 0; --i) {
			reverse += year.charAt(i);
		}
		return reverse;
		
	}
	public static boolean checkPalindrome(String startDate, String endDate, int year, String reverseYear) {
		
		int n = startDate.length();
		int m = endDate.length();
	
		int startYear = Integer.parseInt(startDate.substring(n-4, n));
		int endYear = Integer.parseInt(endDate.substring(n-4, n));
		
		if(startYear > endYear) { System.out.println("Invalid input"); return false; }
		
		int startMonth = Integer.parseInt(startDate.substring(2, 4));
		int endMonth = Integer.parseInt(endDate.substring(2, 4));
		
		int startDay = Integer.parseInt( startDate.substring(0, 2));
		int endDay = Integer.parseInt( endDate.substring(0, 2));
				
		int reverse_day = Integer.parseInt( reverseYear.substring(0, 2));
		int reverse_month = Integer.parseInt(reverseYear.substring(2, 4));
		
		if(reverse_month >= 1 && reverse_month <= 12) {
			if(reverse_day >= 1 && reverse_day <= numberOfDaysinMonth(reverse_month, year)) {
				return true;
			}			
		}	
	
		return false;
	}
	
	public static void printPalindormes(String startDate, String endDate) { 
		int n = startDate.length();
		int m = endDate.length();
		
		if(m != n || n != 8) { System.out.println("Invalid input"); return; }
		
		int startYear = Integer.parseInt(startDate.substring(n-4, n));
		int endYear = Integer.parseInt(endDate.substring(n-4, n));
		
		if(startYear > endYear) { System.out.println("Invalid input"); return ; }
		for(int i = startYear; i <= endYear; ++i) {
			
			String reverseYear = reverseYear(i + "");

			if(checkPalindrome(startDate, endDate, i , reverseYear)) {
					System.out.println(reverseYear  + i);
			}
		 }		
		}
		
	/*	for(int i = startYear; i <= endYear; ++i) {
			for(int j = startMonth; j <= endMonth; ++j) {
				for(int k = startDay; k <= endDay; ++k) { 
					if( k >= 0 && k <= 9) {
						day += "0" + k;
					}
					else day += k;
					
					if( j >= 0 && j <= 9) {
						month += "0" + j;
					}
					else month += j;
					if( i >= 0 && i <= 9) {
						year += "0" + i;
					}
					else year += i;
					
					if(checkPalindrome(month+day, year)) System.out.println(month+day+year);
				}
			}	
		}
	*/	
	//}
	public static void main(String args[]) {
		String start = "01012000";
		String end = "12122090";
		printPalindormes(start, end);
	}
}	



