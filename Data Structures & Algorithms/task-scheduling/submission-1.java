class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char t: tasks) {
            counts[t - 'A']++;
        }

        Arrays.sort(counts);
        int fMax = counts[25];
        // A_ _A_ _A (fMax = 3, idle = 3-1)
        int idle = (fMax-1) * n; 

        for (int i = 24; i >= 0; i--) {
            // in first iteration we have 2 idles, among which we can fill min(next-task-count, 2) idles
            // reduce that from the original idle count
            idle -= Math.min(counts[i], fMax-1);
        }

        // finally, if the idle gets filled with tasks, it will go -ve in that case reset it to 0
        if (idle < 0) {
            idle = 0;
        }

        // total time taken = length of tasks + idle time
        return tasks.length + idle;
    }
}
