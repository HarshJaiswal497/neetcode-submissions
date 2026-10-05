class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String word : strs){
            sb.append(word.length()).append("#").append(word);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i < str.length()){
            int deli = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, deli));
            String word = str.substring(deli+1, deli+len+1);
            res.add(word);
            i = deli+len+1;
        }
        return res;
    }
}
