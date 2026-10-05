class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];
        Map<Integer, Integer> hm = new HashMap<>();
        for(int n: nums){
            hm.put(n, hm.getOrDefault(n, 0)+1);
        }
        //min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> hm.get(a) -                                                                       hm.get(b));
        for(int key: hm.keySet()){
            pq.offer(key);
            while(pq.size() > k){
                pq.poll();
            }
        }
        for(int i=0; i<k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
