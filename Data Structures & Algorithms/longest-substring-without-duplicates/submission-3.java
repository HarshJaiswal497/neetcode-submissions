class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int l=0, r=0, maxL = 0;

        while(r < s.length()){
            char ch = s.charAt(r);
            while(hs.contains(ch)){
                hs.remove(s.charAt(l));
                l++;
            }
            maxL = Math.max(maxL, r-l+1);
            hs.add(ch);
            r++;
        }
        return maxL;
    }
}
