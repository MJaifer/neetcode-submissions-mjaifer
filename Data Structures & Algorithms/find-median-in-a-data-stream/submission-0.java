class MedianFinder {
    Queue<Integer> min;
    Queue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (!min.isEmpty() && min.peek() < num) {
            int temp = min.remove();
            min.add(num);
            num = temp;
        }
        max.add(num);
        if (max.size() - min.size() > 1) {
            min.add(max.remove());
        }
    }
    
    public double findMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return (double) max.peek();
        }
    }
}
