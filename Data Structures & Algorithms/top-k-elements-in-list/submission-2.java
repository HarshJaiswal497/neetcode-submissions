class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];
        Map<Integer, Integer> hm = new HashMap<>();
        for(int n: nums){
            hm.put(n, hm.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> hm.get(b) -                                                                       hm.get(a));
        for(int key: hm.keySet()){
            pq.offer(key);
        }
        for(int i=0; i<k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
