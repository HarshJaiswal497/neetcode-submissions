class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int res[] = new int[len];
        int prefix = 1, postfix = 1;
        for(int i=0; i<len; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }
        for(int i=len-1; i>=0; i--){
            res[i] = postfix*res[i];
            postfix *= nums[i];
        }
        return res;
    }
}  
