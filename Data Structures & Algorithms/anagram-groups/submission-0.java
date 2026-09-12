class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] charSet = strs[i].toCharArray();
            Arrays.sort(charSet);
            String key = new String(charSet);
            if(hm.containsKey(key)){
                hm.get(key).add(strs[i]);
            }else{
                hm.put(key, new ArrayList<String>(Arrays.asList(strs[i])));
            }
        }
        return new ArrayList<>(hm.values());
    }
}
