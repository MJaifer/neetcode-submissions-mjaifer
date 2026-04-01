class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int resLen = len - k + 1;
        int[] res = new int[resLen];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int r = 0; r < len; r++) {
            
            // if first element in deque is out of current window, remove from first
            if (!deque.isEmpty() && deque.peekFirst() == r - k) {
                deque.removeFirst();
            }

            int curr = nums[r];
            // keep the deque motonically increasing by removing smaller elements from last
            while (!deque.isEmpty() && nums[deque.peekLast()] <= curr) {
                deque.removeLast();
            }
            deque.addLast(r);

            // insert to the res if responseIndex is valid
            // response index starts if current window length == k
            // currentWindow len = r - responseIndex + 1
            // r - responseIndex + 1 = k => responseIndex = r - k + 1
            int responseIndex = r - k + 1;
            if (responseIndex >= 0) {
                res[responseIndex] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
