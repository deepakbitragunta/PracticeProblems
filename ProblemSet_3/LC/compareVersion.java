public class compareVersion {
    public static int compareVersion(String version1, String version2) {
    	if(version1.indexOf('.') < 0 && version2.indexOf('.') < 0) {
            int v1 = Integer.parseInt(version1);
            int v2 = Integer.parseInt(version2);
            
            if(v1 < v2) {
                return -1; 
            } else if(v1 > v2) {
                return 1;
            } else {
                return 0;
            }
        }
        
        String all_version1[] = version1.split("\\.");
        String all_version2[] = version2.split("\\.");
        int n1 = all_version1.length;
        int n2 = all_version2.length;
        
        for(int i = 0, j = 0; i < n1 || j < n2; ++i, ++j) {
            int c = all_version1[i].compareTo(all_version2[j]);
            if(c  < 0) {
              return -1;  
            } else if(c > 0) {
                return 1;
            } 
        }
        
       return 0;
    }
		
		public static void main(String args[]) {
			System.out.println(compareVersion("1", "1.1"));
		}
}