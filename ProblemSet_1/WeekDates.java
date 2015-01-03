public class WeekDates {

	static int days[] = {0, 31,28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
	static String day_names[] = {"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	
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
	
	public static void printWeek(int day, int month, int year, int day_num) {
		if((month < 1 && month > 12) || (day < 1 || day > 31) || year > Integer.MAX_VALUE)  return;
		
		int total_days = numberOfDaysinMonth(month, year);
		String result = "";
		int temp_day_num = day_num, temp_day = day, temp_month = month, temp_year = year;
		
		
		for(int i = day_num ; i > 1; --i) {
			
			temp_day_num -= 1;
			
			if(temp_day_num < 1) {
				temp_day_num = 7;
			}
			temp_day--;
			if(temp_day < 1) {
				temp_month--;
			}
			
			if(temp_month < 1) {
				temp_month = 12;
				temp_year--;
				temp_day = days[temp_month];
			}			
			
			result = temp_day + "/" + temp_month + "/" + temp_year + ", " + day_names[temp_day_num] + "\n" + result;
		}
		
		result += day + "/" + month + "/" + year + ", " + day_names[day_num] + "\n";
		
		temp_day_num = day_num; 
		temp_day = day;
		temp_month = month;
		temp_year = year;
		
		for(int i = day_num ; i < 7; ++i) {
			temp_day_num += 1;
			
			if(temp_day_num > 7) {
				temp_day_num = 1;
			}	
			temp_day++;
			if(temp_day > total_days) {
				temp_day = 1;
				temp_month++;
			}
			if(temp_month > 12)  {
				temp_month = 1;
				temp_year++;
			}	
			result += temp_day + "/" + temp_month + "/" + temp_year + ", " + day_names[temp_day_num] + "\n";
		}
			
		System.out.println(result);
	}
	
	public static void main(String args[]) {
		
		printWeek(1, 1, 2013, 3);	
	}
}