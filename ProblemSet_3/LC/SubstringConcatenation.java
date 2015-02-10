import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenation {
    public static List<Integer> findSubstring(String s, String[] l) {
        List<Integer> list = new ArrayList<Integer>();
        
        if( s == null || s.length() == 0 || l.length == 0) return list;
        int n = s.length();
        int k = l.length;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int p = 0; p < l.length; ++p) {
            if(!map.containsKey(l[p])) {
                map.put(l[p], 1);
            } else {
                map.put(l[p], map.get(l[p]) + 1);
            }
        }
        
        int m = l[0].length();
        int i = 0;
				//QTRJFEYFQR
				
        while(n - i >= m * k) {
            HashMap<String, Integer> map2 = new HashMap<String, Integer>(map);
            for(int j = 0; j < k; ++j) {
                String temp = s.substring(i + j * m, i + (j + 1) * m);
                if(map2.containsKey(temp)) {
                    if(map2.get(temp) - 1 == 0) 
                        map2.remove(temp);
                    else 
                        map2.put(temp, map.get(temp) - 1);
                } else 
                    break;
            }
            if(map2.size() == 0)
                list.add(i);
            ++i;
        }
        
        return list;
    } 
    
    public static void main(String args[]) {
    	System.out.println(findSubstring("aaaaaaaaa", new String []{"aa", "aa", "aa"}).toString());
    }	
   
}