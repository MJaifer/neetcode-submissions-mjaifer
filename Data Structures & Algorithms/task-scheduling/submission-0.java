class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char t: tasks) {
            counts[t - 'A']++;
        }

        // max heap
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        // add all the task counts into priority-queue
        for (int c: counts) {
            if (c > 0) {
                pq.add(c);
            }
        }

        Queue<int[]> queue = new LinkedList<>();    // [count, next-processable-time]
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;

            if (pq.isEmpty()) {
                // optimization: if nothing to process in PQ => time is the next time processable time of Queued task
                time = queue.peek()[1];
            } else {
                // get next task count, process it by reducing one count
                // insert it to queue with [count, next-processable-time]
                // where next-processable-time = time + n
                int count = pq.remove();
                if (--count > 0) {
                    queue.add(new int[] {count, time + n});
                }
            }

            // check if we can insert back anything into the priorityQueue from queue
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                pq.add(queue.remove()[0]);
            }
        }

        return time;
    }
}
