// Link: https://leetcode.com/problems/design-hashmap/description/
// https://leetcode.com/problems/design-hashmap/solutions/3062007/java-2-solutions-explained/?orderBy=most_votes

class MyHashMap {
    int[] mapArray;
    public MyHashMap() {
        mapArray = new int[1000001];
        Arrays.fill(mapArray, -1);
    }

    public void put(int key, int value) {
        mapArray[key] = value;
    }

    public int get(int key) {
        return mapArray[key];
    }

    public void remove(int key) {
        mapArray[key] = -1;
    }
}

// TC: O(10^6) => O(1)
// SC: O(10^6) => O(1)


class MyHashMap {
    int[] mapArray;
    public MyHashMap() {
        mapArray = new int[1000001];
    }

    public void put(int key, int value) {
        mapArray[key] = value + 1;
    }

    public int get(int key) {
        return mapArray[key] - 1;
    }

    public void remove(int key) {
        mapArray[key] = 0;
    }
}

// TC: O(1)
// SC: O(10^6) => O(1)