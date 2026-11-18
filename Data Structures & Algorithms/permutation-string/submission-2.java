class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m){
            return false;
        }
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(char ch : s1.toCharArray()){
            freq1[ch - 'a']++;
        }
        int l=0, r=0;
        while(r < m){
            char ch = s2.charAt(r);
            freq2[ch - 'a']++;
            while(l < r && (r-l+1) > n){
                freq2[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(freq1, freq2)){
                return true;
            }
            r++;
        }
        return false;
    }
}
