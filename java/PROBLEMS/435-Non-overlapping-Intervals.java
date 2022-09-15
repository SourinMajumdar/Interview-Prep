// Link: https://leetcode.com/problems/non-overlapping-intervals/


// https://www.youtube.com/watch?v=7GDcCBaohVQ

// We get the answer array. At the end we subtract the length of our answer array from interval's length and that would give us the removal count

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> list = new LinkedList<>();

        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = list.getLast();

            if (last[1] > curr[0]) {
                last[1] = Math.min(last[1], curr[1]);
                list.removeLast();
                list.add(last);

            } else {
                list.add(curr);
            }
        }

        return intervals.length - list.size();
    }
}

// TC: O(n * logn) + O(n)
// SC: O(n) -> At worst case all the intervals can be non-overlapping



// https://www.youtube.com/watch?v=BTObFnHbD4U

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int removeCount = 0;
        int l = 0, r = 1;

        while (r < intervals.length) {
            if (intervals[l][1] <= intervals[r][0]) {
                l = r++;
            } else if (intervals[l][1] <= intervals[r][1]) {
                removeCount++;
                r++;
            } else if (intervals[l][1] >= intervals[r][1]) {
                removeCount++;
                l = r++;
            }

        }

        return removeCount;
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(1)



// We count the number of non-overlapping arrays and return intervals.length - count (which is equal to the number of removals).

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 1;
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= end){
                count++;
                end = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// Sc: O(1)