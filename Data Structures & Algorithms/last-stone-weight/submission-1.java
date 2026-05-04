class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int stone: stones) {
            pq.add(stone);
        }

        while (pq.size() >= 2) {
            int x = pq.remove();
            int y = pq.remove();

            if (x != y) {
                pq.add(Math.abs(x-y));
            }
        }

        return pq.isEmpty()? 0: pq.peek();
    }
}
