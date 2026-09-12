class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> hm = new HashMap<>();
        for(String s: strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if(hm.containsKey(key)){
                hm.get(key).add(s);
            }else{
                hm.put(key, new ArrayList<>());
                hm.get(key).add(s);
            }
        }
        for(List<String> ls: hm.values()){
            res.add(new ArrayList(ls));
        }
        return res;
    }
}
