class Solution {
    private boolean isAlphaNumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l<r){
            while(!isAlphaNumeric(s.charAt(l)) && l<r){
                l++;
            }
            while(!isAlphaNumeric(s.charAt(r)) && l<r){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
