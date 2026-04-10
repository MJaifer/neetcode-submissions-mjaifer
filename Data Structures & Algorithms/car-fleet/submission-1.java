class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = speed.length;

        int[][] pairs = new int[len][2];
        for (int i = 0; i < len; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        double prevTime = (double) (target - pairs[0][0]) / pairs[0][1];
        int fleet = 1;
        for(int i = 1; i < len; i++) {
            int[] pair = pairs[i];
            double time = (double) (target - pair[0]) / pair[1];
            if (time > prevTime) {
                fleet++;
                prevTime = time;
            }
        }
        return fleet;
    }
}
