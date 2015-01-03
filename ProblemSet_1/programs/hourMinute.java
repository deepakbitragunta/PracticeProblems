public class hourMinute {
 
	public static void main(String args[]) {

		String time = "2:15";
		String timeobj[] = time.split(":");
	
		double angle = calculateAngle(Integer.parseInt(timeobj[0]), Integer.parseInt(timeobj[1]));
		System.out.println("Angle is:" + angle);
	
	}

	public static double calculateAngle(int hours, int mins) {
		double angle = Math.abs(hours * 30 + mins * 0.5 - 6 * mins);
		if(angle > 180) {
			angle = 360 - angle;
		}
	return angle;
	}
}