class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> hm = new HashMap<>();
        for(String s: strs){
            int freq[] = new int[26];
            for(int i=0; i<s.length(); i++){
                freq[s.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                sb.append(freq[i]).append('#');
            }
            String key = sb.toString();
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
