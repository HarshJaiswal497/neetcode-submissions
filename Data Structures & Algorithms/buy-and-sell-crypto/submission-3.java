class Solution {
    public int maxProfit(int[] prices) {
        int l=0, r=0;
        int maxP = 0;
        while(l<=r && r < prices.length){
            if(prices[r] < prices[l]){
                l = r;
            }
            if(r > l && prices[r] > prices[l]){
                maxP = Math.max(maxP, (prices[r]-prices[l]));  
            }
            r++;
        }
        return maxP;
    }
}
