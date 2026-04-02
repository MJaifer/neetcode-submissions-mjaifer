class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            int[] arr = new int[26];
            for (char c: str.toCharArray()) {
                arr[c - 'a']++;
            }
            String key = Arrays.toString(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
