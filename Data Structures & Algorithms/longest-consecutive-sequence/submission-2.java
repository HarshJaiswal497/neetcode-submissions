class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> hs = new HashSet<>();
        for(int n : nums){
            hs.add(n);
        }
        int max = 1;
        for(int i=0; i<nums.length; i++){
            if(hs.contains(nums[i]-1)){
                continue;
            }else{
                int len = 1;
                int num = nums[i];
                while(hs.contains(num+1)){
                    len++;
                    max = Math.max(max, len);
                    num++;
                }
            }
        }
        return max;
    }
}
