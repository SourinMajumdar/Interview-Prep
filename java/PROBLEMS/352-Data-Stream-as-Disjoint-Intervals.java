// Link: https://leetcode.com/problems/data-stream-as-disjoint-intervals/

class SummaryRanges {
    // We will use a treeset data structure
    // it will keep our numbers in sorted order
    private TreeSet<Integer> set;
    public SummaryRanges() {
        set = new TreeSet<>();  // initialise the treeset
    }

    public void addNum(int value) {
        set.add(value); // add the value to treeset
    }

    public int[][] getIntervals() {
        // initialise an arraylist to store the intervals
        List<int[]> intervals = new ArrayList<>();
        // initialise the start and end values with the
        // first element that is present in the set
        int start = set.first();
        int end = set.first();

        // we will iterate on the set, if its at number adjacent to 'end'
        // we will update 'end' until we encounter a disjoint number
        for (int v : set) {
            // simply skip the first element because
            // we ned to check from second element
            if (v == start) {
                continue;
            }
            // if the number is +1 the 'end' (adjacent), we will update 'end'
            // say 'end' is 6, we encounter 7, so 6 & 7 are consecutive/adjacent
            // so 'end' is updated to 7
            else if (v == end + 1) {
                end = v;
            }
            // when we find a disjoint case, say 'end' is 7 and we encounter 9
            // they are disjoint, so we push the interval obtained so far
            else {
                intervals.add(new int[] {start, end});  // pushing the interval
                start = end = v;    // we will start afresh from 9
            }
        }

        // at the end we will be left with an interval,
        // because we finished iterating on the treeset
        // so we will push that interval to the list
        intervals.add(new int[] {start, end});
        // return the list as a 2D array of intervals
        return intervals.toArray(new int[0][]);
    }
}

// TC: O(logn) + O(n)
// SC: O(n)

class SummaryRanges {
    private TreeSet<Integer> set;
    public SummaryRanges() {
        set = new TreeSet<>();
    }

    public void addNum(int value) {
        set.add(value);
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>();
        int start = set.first();
        int end = set.first();
        for (int v : set) {
            if (v == start) {
                continue;
            } else if (v == end + 1) {
                end = v;
            } else {
                intervals.add(new int[] {start, end});
                start = end = v;
            }
        }

        intervals.add(new int[] {start, end});
        return intervals.toArray(new int[0][]);
    }
}


class SummaryRanges {
    private boolean[] set;
    public SummaryRanges() {
        set = new boolean[10000 + 5];
    }

    public void addNum(int value) {
        set[value] = true;
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < set.length; i++) {
            if (!set[i]) {
                continue;
            }

            int start = i;
            while (i < set.length && set[i]) i++;
            int end = i - 1;
            intervals.add(new int[] {start, end});
        }

        return intervals.toArray(new int[0][]);
    }
}

// TC: O(10^4) => O(1)
// SC: O(10^4) => O(1)