class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] res = new int[n-k+1];
        int l=0, r=0;
        Deque<Integer> deq = new LinkedList<>();
        while(r < n){
            while(!deq.isEmpty() && nums[deq.getLast()] < nums[r]){
                deq.removeLast();
            }
            deq.addLast(r);
            if(l > deq.getFirst()){
                deq.removeFirst();
            }
            if((r+1) >= k){
                res[l] = nums[deq.getFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
 