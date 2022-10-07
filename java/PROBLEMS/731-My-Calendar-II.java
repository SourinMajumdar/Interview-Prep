// Link: https://leetcode.com/problems/my-calendar-ii/
// Solution: https://www.youtube.com/watch?v=ElJdCIhkkZ8

class MyCalendarTwo {
    TreeMap<Integer, Integer> calendar;

    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        int activeBookings = 0;

        for (int ending : calendar.values()) {
            activeBookings += ending;

            if (activeBookings > 2) {
                calendar.put(start, calendar.getOrDefault(start, 0) - 1);
                calendar.put(end, calendar.getOrDefault(end, 0) + 1);
                return false;
            }
        }

        return true;
    }
}

// Time Complexity: O(N ^ 2)
// For each new event, we update the changes at two points in O(logN) because we keep the HashMap in sorted order.
// Then we traverse diff in O(N) time.

// SC: O(n)


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */