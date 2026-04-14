class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timestampMap = map.get(key);
        if (timestampMap == null) return "";
        Map.Entry<Integer, String> entry = timestampMap.floorEntry(timestamp);
        return entry == null? "": entry.getValue();
    }
}
