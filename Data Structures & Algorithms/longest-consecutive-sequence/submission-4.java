class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int i: nums){
            hs.add(i);
        }
        int lon = 0;
        for(int i=0; i<nums.length; i++){
            if(hs.contains(nums[i]-1)){
                continue;
            }
            int len = 1;
            int num = nums[i];
            while(hs.contains(num+1)){
                len++;
                num++;
            }
            lon = Math.max(lon, len);
        }
        return lon;
    }
}
