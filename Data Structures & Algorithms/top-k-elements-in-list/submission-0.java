class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> reverseMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            reverseMap.putIfAbsent(freq, new ArrayList<>());
            reverseMap.get(freq).add(num);
        }

        int[] res = new int[k];
        int resIndex = 0;
        // max freq = length of array
        // min freq = 1
        for (int i = nums.length; i > 0; i--) {
            List<Integer> list = reverseMap.get(i);
            if (list == null) {
                continue;
            }

            for (int resNum: list) {
                if (resIndex == k) {
                    break;
                }
                res[resIndex++] = resNum;
            }
        }
        
        return res;
    }
}
