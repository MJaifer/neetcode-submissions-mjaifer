class Solution {
    public int leastInterval(char[] tasks, int n) {
        // find max frequeny of task (fMax) and no of tasks with max frequency (nMax)
        int[] counts = new int[26];
        for (char t: tasks) {
            counts[t - 'A']++;
        }

        Arrays.sort(counts);
        int fMax = counts[25];
        int nMax = 1;
        for (int i = 24; i >= 0; i--) {
            if (counts[i] == fMax) {
                nMax++;
            } else {
                break;
            }
        }

        // consider n = 2, A:3
        // A--A--A => 2*(A--)+A
        // consider n = 2, A:3, B:3
        // AB-AB-AB => 2*(AB-)+AB => (fMax-1)*(n+1) + nMax => (3-1)*(2+1)+2 = 8
        // where (fMax-1) is 2 and (n+1) is (AB-) and nMax is AB which is 2
        // if C is 2 counts, our answer is still  (fMax-1)*(n+1) + nMax = 8
        // if D is one count, out answer will be 9 which is the length of input

        // no of min cycles = Max of (length of tasks) or (fMax-1)*(n+1)+nMax
        return Math.max(tasks.length, (fMax-1)*(n+1)+nMax);
    }
}
