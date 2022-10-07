// Link: https://leetcode.com/problems/my-calendar-iii/
// Solution: https://www.youtube.com/watch?v=eH0-jnHCprc


// Sweep Line Algorithm

class MyCalendarThree {
    TreeMap<Integer, Integer> calendar;

    public MyCalendarThree() {
        calendar = new TreeMap<>();
    }

    public int book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        int activeBookings = 0;
        int maxActiveBookings = 0;

        for (int ending : calendar.values()) {
            activeBookings += ending;
            maxActiveBookings = Math.max(maxActiveBookings, activeBookings);
        }

        return maxActiveBookings;
    }
}

// TC: O(n ^ 2), SC: O(n)
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */