// Link: https://leetcode.com/problems/time-based-key-value-store/
// Solution: https://www.youtube.com/watch?v=kZAZqn_J8Fo


class TimeMap {
    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Data> data = map.get(key);
        return findClosestvalue(data, timestamp);
    }

    private String findClosestvalue(List<Data> data, int timestamp) {
        int l = 0, r = data.size() - 1;

        while (l < r) {
            int mid = (l + r + 1) / 2;

            if (data.get(mid).timestamp <= timestamp) l = mid;
            else r = mid - 1;
        }

        Data closestData = data.get(l);
        return closestData.timestamp > timestamp ? "" : closestData.value;
    }

    class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

// TC: O(logn), SC: O(n)

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */