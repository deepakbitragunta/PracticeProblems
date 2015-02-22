public class Calendar {
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

	public static void print(int year) {	
		for(int i = 1; i <= 12; ++i) {
			for(int j = 1; j <= numberOfDaysinMonth(i, year); ++j) {
				System.out.println(i+"/ "+j+"/ "+year);
			}
		
		}
	
	}
	public static void main(String args[]) {
		print(2014);
	}

}