class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = piles[0];
        
        for(int i=1; i<piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        int res = max;
        while(min <= max){
            int avg = min + (max-min)/2;
            int hours = 0;
            for(int i=0; i<piles.length; i++){
                hours += ((piles[i]+avg-1)/avg);
            }
            if(hours <= h){
                res = avg;
                max = avg-1;
            }else{
                min = avg+1;
            }
        }
        return res;
    }
}
