class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Min Heap solution TC: O(nlogk), SC: O(n + k)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            minHeap.add(new int[] {entry.getKey(), entry.getValue()});
            
            // if heap size exceeds k, remove the min element
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }


        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.remove()[0];
        }
        
        return res;
    }
}
