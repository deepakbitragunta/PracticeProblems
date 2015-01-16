public class DelimitedSubstrings {
	public static void main(String[] args) {
		String str="4678912356012356";
		System.out.println(getSequences(str));
		System.out.println(getSequences_2(str));
	}
	
	public static String getSequences_2(String str){ 
		int dlength = Integer.parseInt(str.charAt(0) + "");
		int i = 0, j;
		int n = str.length();
		
		StringBuffer result = new StringBuffer();
		if(dlength < 1) return "Invalid";
		
		for(i = 1, j = dlength; i < n; --j) {
			if(j == 1) { j = dlength; }
			if(i + j > n) {
				result.append(str.substring(i, n));
				result.append(";");
				break;
			}
			result.append(str.substring(i, i + j));
			result.append(";");
			i = i + j;
		}
		return result.toString();
	}
	
	public static String getSequences(String str){
		StringBuffer sb=new StringBuffer();
		boolean flag=false;
		
		for(int i=1;i<str.length();i++){
			if(str.charAt(i-1)+1==str.charAt(i)){
				sb.append(str.charAt(i-1));
				flag=true;
			}
			else{
				if(flag){
					sb.append(str.charAt(i-1));
					sb.append(';');
				}
				flag=false;
			}	
		}
		
		if(str.charAt(str.length()-2)+1==str.charAt(str.length()-1)){
			sb.append(str.charAt(str.length()-1));
			sb.append(';');
		}
		
		return sb.toString();
	}
}	