class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int max = 0;
        int l=0, r=0;
        while(r < s.length()){
            if(!hs.contains(s.charAt(r))){
                int len = r-l+1;
                max = Math.max(max, len);
            }
            while(l < r && hs.contains(s.charAt(r))){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            r++;
        }
        return max;
    }
}
