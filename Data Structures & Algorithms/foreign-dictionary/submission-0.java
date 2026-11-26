class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adj = new HashMap<>();
      for(String w : words){
        for(int i=0; i<w.length(); i++){
            char ch = w.charAt(i);
            adj.putIfAbsent(ch, new HashSet<>());
        }
      }
      for(int i=1; i<words.length; i++){
        String prev = words[i-1];
        String curr = words[i];
        int len = Math.min(prev.length(), curr.length());
        boolean foundDiff = false;
        for(int j=0; j<len; j++){
            if(prev.charAt(j) != curr.charAt(j)){
                foundDiff = true;
                adj.get(prev.charAt(j)).add(curr.charAt(j));
                break;
            }
        }
        if(!foundDiff && prev.length() > curr.length()){
            return "";
        }
      }
      int indegree[] = new int[26];
      for(char ch: adj.keySet()){
        for(char con : adj.get(ch)){
            indegree[con - 'a']++;
        }
      }
      Queue<Character> q = new LinkedList<>();
      StringBuilder sb = new StringBuilder();
      for(char ch: adj.keySet()){
        if(indegree[ch - 'a'] == 0){
            q.offer(ch);
        }
      }
      int count = 0;
      while(!q.isEmpty()){
        char curr = q.poll();
        sb.append(curr);
        count++;
        for(char neigh : adj.get(curr)){
            indegree[neigh - 'a']--;
            if(indegree[neigh - 'a'] == 0){
                q.offer(neigh);
            }
        }
      }
      return count == adj.size() ? sb.toString() : "";
    }
}
