// Link: https://leetcode.com/problems/design-hashset/description/
// https://leetcode.com/problems/design-hashset/solutions/3062087/java-easiest-solution-using-array-explained/

class MyHashSet {
    boolean[] setArray;
    public MyHashSet() {
        setArray = new boolean[1000000 + 1];
    }

    public void add(int key) {
        setArray[key] = true;
    }

    public void remove(int key) {
        setArray[key] = false;
    }

    public boolean contains(int key) {
        return setArray[key];
    }
}

// TC: O(1)
// SC: O(10^6 + 1) => O(1)