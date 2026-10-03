
class Solution { 
    public String minWindow(String s, String t) { 
        if (t.length() > s.length()) { 
            return ""; 
        } 
        
        Map<Character, Integer> hmT = new HashMap<>(); 
        Map<Character, Integer> hmS = new HashMap<>(); 
        
        for (int i = 0; i < t.length(); i++) { 
            char ch = t.charAt(i); 
            hmT.put(ch, hmT.getOrDefault(ch, 0) + 1); 
        } 
        
        int resL = -1, resR = -1, resLen = Integer.MAX_VALUE; 
        int l = 0, r = 0; 
        int have = 0, need = hmT.size(); 
        
        while (r < s.length()) { 
            char ch = s.charAt(r); 
            hmS.put(ch, hmS.getOrDefault(ch, 0) + 1); 
            
            // FIX: Use .equals() instead of == for Integer object comparison
            if (hmT.containsKey(ch) && hmT.get(ch).equals(hmS.get(ch))) { 
                have++; 
            } 
            
            while (have == need) { 
                if ((r - l + 1) < resLen) { 
                    resL = l; 
                    resR = r; 
                    resLen = r - l + 1; 
                } 
                
                char leftChar = s.charAt(l);
                hmS.put(leftChar, hmS.get(leftChar) - 1); 
                
                // FIX: Use compareTo or < with primitive casting/unboxing if needed, 
                // but since it's an inequality check (<), Java automatically unboxes it safely here.
                if (hmT.containsKey(leftChar) && hmS.get(leftChar) < hmT.get(leftChar)) { 
                    have--; 
                } 
                l++; 
            } 
            r++; 
        } 
        
        return resLen == Integer.MAX_VALUE ? "" : s.substring(resL, resR + 1); 
    } 
}
