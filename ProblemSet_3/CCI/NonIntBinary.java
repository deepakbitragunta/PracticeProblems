import java.math.BigDecimal;
import java.math.RoundingMode;

public class NonIntBinary {

	public static String convertToBinary(String num) {
		String intString = "";
		
		int intPart = Integer.parseInt(num.substring(0, num.indexOf('.')));
		double decPart = Double.parseDouble(num.substring(num.indexOf('.'), num.length()));
	//	BigDecimal dpart;
		
		while(intPart > 0) {
			int r = intPart % 2;
			intPart >>= 1;
			intString = r + intString;
		}
		StringBuffer decString = new StringBuffer();
		BigDecimal dpart;
		while(decPart > 0) {
			if(decString.length() > 32) return "Error";
			if(decPart == 1) {
				decString.append((int) decPart);
				break;
			}
			
			double r = decPart * 2.0;
			if(r >= 1) {
				decString.append(1);
				dpart = new BigDecimal(r - 1);
				dpart = dpart.setScale(2, RoundingMode.HALF_UP);
				decPart = dpart.doubleValue();
			} 
			else {
				decString.append(0);
				//decPart = r;
				dpart = new BigDecimal(r);
				dpart = dpart.setScale(2, RoundingMode.HALF_UP);
				decPart = dpart.doubleValue();
				
			}
		}
		return intString + "." + decString.toString();
	}	
	
	public static void main(String args[]) {
		System.out.println(convertToBinary("0.625"));
	}
}