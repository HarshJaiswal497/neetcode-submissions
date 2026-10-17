class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                char ch = board[i][j];
                String key = (i/3) + "," + (j/3);
                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(ch)
                    || cols.computeIfAbsent(j, k -> new HashSet<>()).contains(ch)
                    || boxes.computeIfAbsent(key, k -> new HashSet<>()).contains(ch)) {
                    return false;
                }
                rows.get(i).add(ch);
                cols.get(j).add(ch);
                boxes.get(key).add(ch);
            }
        }
        return true;
    }
}
