class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int leftMax = height[l], rightMax = height[r];
        int trapWater = 0;
        while(l < r){
            if(leftMax <= rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                trapWater += (leftMax - height[l]);
            }else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                trapWater += (rightMax - height[r]);
            }
        } 
        return trapWater;
    }
}
