class Solution {
    public int hammingWeight(int n) {
        int set = 0;
        while (n > 0) {
            n = n & (n-1);
            set++;
        }
        return set;
    }
}
