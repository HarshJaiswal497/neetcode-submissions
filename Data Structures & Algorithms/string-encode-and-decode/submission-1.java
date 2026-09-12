class Solution {

    // Encode: word length + '#' + word
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String word : strs) {
            sb.append(word.length()).append("#").append(word);
        }
        return sb.toString();
    }

    // Decode: read length until '#', then extract that many characters
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // find the delimiter '#'
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            // parse length
            int length = Integer.parseInt(str.substring(i, j));
            // extract word
            String word = str.substring(j + 1, j + 1 + length);
            res.add(word);
            // move pointer
            i = j + 1 + length;
        }
        return res;
    }
}