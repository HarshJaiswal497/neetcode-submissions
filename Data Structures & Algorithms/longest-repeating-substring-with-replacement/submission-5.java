class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, r=0;
        int maxL = 0;
        int maxFreq = 0;
        Map<Character, Integer> hm = new HashMap<>();
        while(r < s.length()){
            char ch = s.charAt(r);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(ch));
            while(l < r && (r-l+1)-maxFreq > k){
                hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                l++;
            }
            maxL = Math.max(maxL, r-l+1);
            r++;
        }
        return maxL;
    }
}
