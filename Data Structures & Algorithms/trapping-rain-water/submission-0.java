class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft[] = new int[n];
        int maxRight[] = new int[n];
        int maxL=0, maxR=0;
        for(int i=0; i<n; i++){
            maxLeft[i] = maxL;
            maxL = Math.max(maxL, height[i]);
        }
        for(int i=n-1; i>=0; i--){
            maxRight[i] = maxR;
            maxR = Math.max(maxR, height[i]);
        }
        int total = 0;
        for(int i=0; i<n; i++){
            total += Math.max(0, (Math.min(maxLeft[i], maxRight[i]) - height[i]));
        }
        return total;
    }
}
