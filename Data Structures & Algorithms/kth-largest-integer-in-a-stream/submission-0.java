class KthLargest {
    Queue<Integer> pq;
    int size;
    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue<>();

        for (int num: nums) {
            this.add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if (pq.size() > size) {
            pq.remove();
        }

        return pq.peek();
    }
}
