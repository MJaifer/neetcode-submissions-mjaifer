class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        
        // max heap sorted by 3rd item in each element
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));

        for (int[] point: points) {
            int x = point[0];
            int y = point[1];
            pq.add(new int[]{x, y, (x*x + y*y)});

            if (pq.size() > k) {
                pq.remove();
            }
        }

        for (int i = 0; i < k; i++) {
            int[] pair = pq.remove();
            res[i] = new int[] {pair[0], pair[1]};
        }

        return res;
    }
}
