public class minWindowSubstring {
    
    public String minWindow(String S, String T) {
        if(S == null || T == null) return null;
        int i;
        
        if(S.length() == 0 && T.length() == 0) 
            return "";
        if(S.length() < T.length()) 
            return "";
            
        int m = T.length();
        int n = S.length();
        
        HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        
        for(i = 0; i < m; ++i) {
            if(needToFind.containsKey(T.charAt(i))) {
                needToFind.put(T.charAt(i), needToFind.get(T.charAt(i)));
            } else {
                needToFind.put(T.charAt(i), 1);
            }
        }
        
        int foundCounter = 0;
        int start  = 0;
        int end = 0;
       
        int minStart = -1;
        int minEnd = S.length();
        
        for(i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if(found.containsKey(c)) {
                found.put(c, found.get(c) + 1); 
                
                if(found.get(c) <= needToFind.get(c)) {
                    foundCounter++;
                }
              
                if(foundCounter == T.length()) {
                    while(!needToFind.containsKey(S.charAt(start)) || found.get(S.charAt(start)) > needToFind.get(S.charAt(start))) {
                        if(needToFind.containsKey(S.charAt(start))) {
                            found.put(S.charAt(start), found.get(S.charAt(start)) + 1);
                        }
                        start++;
                    }
                    
                    if( i - start < minEnd - minStart) {
                        minStart = start;
                        minEnd = i;
                    }
                }
            }
        }
        
        if(minStart == -1)
            return "";
  
        return S.substring(minStart, minEnd + 1);
        
      // My solution    
      /*  for(i = m; i >= 1; --i) {
            for(int j = 0; j < n - m; ++j) {
                String temp = S.substring(j, j + i);
                for(int k = 0; k < T.length(); ++k) {
                    
                   for()
                }
            }
        }*/
        
    }
}