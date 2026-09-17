class Solution {
    public boolean canEat(int[] piles, int h, int curr) {
        int total = 0;
        for (int i = 0; i < piles.length; i++) {
            total += ((piles[i] + curr - 1) / curr);
        }
        return total <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        int l = 1, r = max;
        int res = max;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canEat(piles, h, m)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}
