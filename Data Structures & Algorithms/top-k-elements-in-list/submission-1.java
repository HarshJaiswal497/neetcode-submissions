class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[1]-a[1]
        );
        for(int n : hm.keySet()){
            pq.offer(new int[]{n, hm.get(n)});
        }
        int res[] = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
 